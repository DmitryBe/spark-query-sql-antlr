
grammar Sparksql;

root: select_statement
    ;

select_statement
    : with_expression? query_expression order_by_clause? limit_clause?
    ;

limit_clause
    : LIMIT number
    ;

order_by_clause
    : ORDER BY order_by_expression (',' order_by_expression)*
      (OFFSET expression (ROW | ROWS) (FETCH (FIRST | NEXT) expression (ROW | ROWS) ONLY)?)?
    ;

order_by_expression
    : expression (ASC | DESC)?
    ;

query_expression
    : (query_specification | '(' query_expression ')') union*
    ;

with_expression
    : WITH (XMLNAMESPACES ',')? common_table_expression (',' common_table_expression)*
    ;

common_table_expression
    : expression_name=id_1 ('(' column_name_list ')')? AS '(' select_statement ')'
    ;

column_name_list
    : column_name (',' column_name)*
    ;

query_specification
    : SELECT (ALL | DISTINCT)? (TOP expression PERCENT? (WITH TIES)?)?
      select_list
      (INTO into_table=table_name)?
      (FROM table_source (',' table_source)*)?
      (WHERE where=search_condition)?
      (GROUP BY group_by_item (',' group_by_item)*)?
      (HAVING having=search_condition)?
    ;

union
    : (UNION ALL? | EXCEPT | INTERSECT) (query_specification | ('(' query_expression ')')+)
    ;

table_source
    : table_source_item_joined
    | '(' table_source_item_joined ')'
    ;

table_source_item_joined
    : table_source_item join_part*
    ;

table_source_item
    : table_name_with_hint        as_table_alias?
    //| rowset_function             as_table_alias?
    | derived_table              (as_table_alias column_alias_list?)?
    //| function_call               as_table_alias?
    | LOCAL_ID                    as_table_alias?
    //| LOCAL_ID '.' function_call (as_table_alias column_alias_list?)?
    ;

group_by_item
    : expression
    /*| rollup_spec
    | cube_spec
    | grouping_sets_spec
    | grand_total*/
    ;

derived_table
    : subquery
    | '(' subquery ')'
    | table_value_constructor
    ;

table_value_constructor
    : VALUES '(' expression_list ')' (',' '(' expression_list ')')*
    ;

expression_list
    : expression (',' expression)*
    ;

subquery
    : select_statement
    ;

join_part
    : (INNER? |
       join_type=(LEFT | RIGHT | FULL) OUTER?) (join_hint=(LOOP | HASH | MERGE | REMOTE))?
       JOIN table_source ON search_condition
    | CROSS JOIN table_source
    | CROSS APPLY table_source
    | OUTER APPLY table_source
    ;

table_name_with_hint
    : table_name with_table_hints?
    ;


as_table_alias
    : AS? table_alias
    ;

table_alias
    : id_1 with_table_hints?
    ;

// https://msdn.microsoft.com/en-us/library/ms187373.aspx
with_table_hints
    : WITH? '(' table_hint (',' table_hint)* ')'
    ;

// Id runtime check. Id can be (INDEX, FORCESCAN, FORCESEEK, HOLDLOCK, NOLOCK, NOWAIT, PAGLOCK, READCOMMITTED,
// READCOMMITTEDLOCK, READPAST, READUNCOMMITTED, REPEATABLEREAD, ROWLOCK, SERIALIZABLE, SNAPSHOT,

table_hint
    : NOEXPAND? ( INDEX '(' index_value (',' index_value)* ')'
                | INDEX '=' index_value
                | ID)
    ;

index_value
    : ID | DECIMAL
    ;

column_alias_list
    : '(' column_alias (',' column_alias)* ')'
    ;

column_alias
    : id_1
    | STRING
    ;


expression
    : DEFAULT
    | NULL
    | LOCAL_ID
    | constant
    | expression COLLATE id_1
    | case_expr
    | full_column_name
    | '(' expression ')'
    | '(' subquery ')'
    | '~' expression
    | expression op=('*' | '/' | '%') expression
    | op=('+' | '-') expression
    | expression op=('+' | '-' | '&' | '^' | '|') expression
    | expression comparison_operator expression
    | aggregate_windowed_function
    ;

aggregate_windowed_function
    : AVG '(' all_distinct_expression ')'
    | CHECKSUM_AGG '(' all_distinct_expression ')'
    | GROUPING '(' expression ')'
    | GROUPING_ID '(' expression_list ')'
    | MAX '(' all_distinct_expression ')'
    | MIN '(' all_distinct_expression ')'
    | SUM '(' all_distinct_expression ')'
    | STDEV '(' all_distinct_expression ')'
    | STDEVP '(' all_distinct_expression ')'
    | VAR '(' all_distinct_expression ')'
    | VARP '(' all_distinct_expression ')'
    | COUNT '(' ('*' | all_distinct_expression) ')'
    | COUNT_BIG '(' ('*' | all_distinct_expression) ')'
    ;

all_distinct_expression
    : (ALL | DISTINCT)? expression
    ;

constant
    : STRING // string, datetime or uniqueidentifier
    | BINARY
    | number
    | sign? (REAL | FLOAT)  // float or decimal
    | sign? '$' (DECIMAL | FLOAT)       // money
    ;

sign
    : PLUS
    | MINUS
    ;

number
    : sign? DECIMAL
    ;

select_list
    : select_list_elem (',' select_list_elem)*
    ;

select_list_elem
    : (table_name '.')? ('*' | '$' (IDENTITY | ROWGUID))
    | column_alias '=' expression
    | expression (AS? column_alias)?
    ;

full_column_name
    : (table_name '.')? column_name
    ;

column_name
    : id_1
    ;

case_expr
    : CASE expression (WHEN expression THEN expression)+ (ELSE expression)? END
    | CASE (WHEN search_condition THEN expression)+ (ELSE expression)? END
    ;

table_name
    : ((schema=id_1)? '.' | schema=id_1 '.')? table=id_1
    ;

search_condition
    : search_condition_or (AND search_condition_or)*
    ;

search_condition_or
    : search_condition_not (OR search_condition_not)*
    ;

search_condition_not
    : NOT? predicate
    ;


predicate
    : EXISTS '(' subquery ')'
    | expression comparison_operator expression
    | expression comparison_operator (ALL | SOME | ANY) '(' subquery ')'
    | expression NOT? BETWEEN expression AND expression
    | expression NOT? IN '(' (subquery | expression_list) ')'
    | expression NOT? LIKE expression (ESCAPE expression)?
    | expression IS null_notnull
    | '(' search_condition ')'
    ;


id_1  : simple_id
    | DOUBLE_QUOTE_ID
    | SQUARE_BRACKET_ID
    ;

comparison_operator
    : '=' | '>' | '<' | '<' '=' | '>' '=' | '<' '>' | '!' '=' | '!' '>' | '!' '<'
    ;

simple_id
    : ID
    | ABSOLUTE
    | APPLY
    | AUTO
    | AVG
    | BASE64
    | CALLER
    | CAST
    | CATCH
    | CHECKSUM_AGG
    | COMMITTED
    | CONCAT
    | COOKIE
    | COUNT
    | COUNT_BIG
    | DELAY
    | DELETED
    | DENSE_RANK
    | DISABLE
    | DYNAMIC
    | ENCRYPTION
    | FAST
    | FAST_FORWARD
    | FIRST
    | FOLLOWING
    | FORWARD_ONLY
    | FULLSCAN
    | GLOBAL
    | GO
    | GROUPING
    | GROUPING_ID
    | HASH
    | INSENSITIVE
    | INSERTED
    | ISOLATION
    | KEYSET
    | KEEPFIXED
    | LAST
    | LEVEL
    | LOCAL
    | LOCK_ESCALATION
    | LOGIN
    | LOOP
    | MARK
    | MAX
    | MIN
    | MODIFY
    | NAME
    | NEXT
    | NOCOUNT
    | NOEXPAND
    | NORECOMPUTE
    | NTILE
    | NUMBER
    | OFFSET
    | ONLY
    | OPTIMISTIC
    | OPTIMIZE
    | OUT
    | OUTPUT
    | OWNER
    | PARTITION
    | PATH
    | PRECEDING
    | PRIOR
    | RANGE
    | RANK
    | READONLY
    | READ_ONLY
    | RECOMPILE
    | RELATIVE
    | REMOTE
    | REPEATABLE
    | ROOT
    | ROW
    | ROWGUID
    | ROWS
    | ROW_NUMBER
    | SAMPLE
    | SCHEMABINDING
    | SCROLL
    | SCROLL_LOCKS
    | SELF
    | SERIALIZABLE
    | SNAPSHOT
    | STATIC
    | STATS_STREAM
    | STDEV
    | STDEVP
    | SUM
    | THROW
    | TIES
    | TIME
    | TRY
    | TYPE
    | TYPE_WARNING
    | UNBOUNDED
    | UNCOMMITTED
    | UNKNOWN
    | USING
    | VAR
    | VARP
    | VIEW_METADATA
    | WORK
    | XML
    | XMLNAMESPACES
    ;

null_notnull
    : NOT? NULL
    ;



// Lexer

// Basic keywords (from https://msdn.microsoft.com/en-us/library/ms189822.aspx)
LIMIT:                           L I M I T;
ADD:                             A D D;
ALL:                             A L L;
ALTER:                           A L T E R;
AND:                             A N D;
ANY:                             A N Y;
AS:                              A S;
ASC:                             A S C;
AUTHORIZATION:                   A U T H O R I Z A T I O N;
BACKUP:                          B A C K U P;
BEGIN:                           B E G I N;
BETWEEN:                         B E T W E E N;
BREAK:                           B R E A K;
BROWSE:                          B R O W S E;
BULK:                            B U L K;
BY:                              B Y;
CASCADE:                         C A S C A D E;
CASE:                            C A S E;
CHECK:                           C H E C K;
CHECKPOINT:                      C H E C K P O I N T;
CLOSE:                           C L O S E;
CLUSTERED:                       C L U S T E R E D;
COALESCE:                        C O A L E S C E;
COLLATE:                         C O L L A T E;
COLUMN:                          C O L U M N;
COMMIT:                          C O M M I T;
COMPUTE:                         C O M P U T E;
CONSTRAINT:                      C O N S T R A I N T;
CONTAINS:                        C O N T A I N S;
CONTAINSTABLE:                   C O N T A I N S T A B L E;
CONTINUE:                        C O N T I N U E;
CONVERT:                         C O N V E R T;
CREATE:                          C R E A T E;
CROSS:                           C R O S S;
CURRENT:                         C U R R E N T;
CURRENT_DATE:                    C U R R E N T '_' D A T E;
CURRENT_TIME:                    C U R R E N T '_' T I M E;
CURRENT_TIMESTAMP:               C U R R E N T '_' T I M E S T A M P;
CURRENT_USER:                    C U R R E N T '_' U S E R;
CURSOR:                          C U R S O R;
DATABASE:                        D A T A B A S E;
DBCC:                            D B C C;
DEALLOCATE:                      D E A L L O C A T E;
DECLARE:                         D E C L A R E;
DEFAULT:                         D E F A U L T;
DELETE:                          D E L E T E;
DENY:                            D E N Y;
DESC:                            D E S C;
DISK:                            D I S K;
DISTINCT:                        D I S T I N C T;
DISTRIBUTED:                     D I S T R I B U T E D;
DOUBLE:                          D O U B L E;
DROP:                            D R O P;
DUMP:                            D U M P;
ELSE:                            E L S E;
END:                             E N D;
ERRLVL:                          E R R L V L;
ESCAPE:                          E S C A P E;
EXCEPT:                          E X C E P T;
EXEC:                            E X E C;
EXECUTE:                         E X E C U T E;
EXISTS:                          E X I S T S;
EXIT:                            E X I T;
EXTERNAL:                        E X T E R N A L;
FETCH:                           F E T C H;
FILE:                            F I L E;
FILLFACTOR:                      F I L L F A C T O R;
FOR:                             F O R;
FOREIGN:                         F O R E I G N;
FREETEXT:                        F R E E T E X T;
FREETEXTTABLE:                   F R E E T E X T T A B L E;
FROM:                            F R O M;
FULL:                            F U L L;
FUNCTION:                        F U N C T I O N;
GOTO:                            G O T O;
GRANT:                           G R A N T;
GROUP:                           G R O U P;
HAVING:                          H A V I N G;
HOLDLOCK:                        H O L D L O C K;
IDENTITY:                        I D E N T I T Y;
IDENTITYCOL:                     I D E N T I T Y C O L;
IDENTITY_INSERT:                 I D E N T I T Y '_' I N S E R T;
IF:                              I F;
IN:                              I N;
INDEX:                           I N D E X;
INNER:                           I N N E R;
INSERT:                          I N S E R T;
INTERSECT:                       I N T E R S E C T;
INTO:                            I N T O;
IS:                              I S;
JOIN:                            J O I N;
KEY:                             K E Y;
KILL:                            K I L L;
LEFT:                            L E F T;
LIKE:                            L I K E;
LINENO:                          L I N E N O;
LOAD:                            L O A D;
MERGE:                           M E R G E;
NATIONAL:                        N A T I O N A L;
NOCHECK:                         N O C H E C K;
NONCLUSTERED:                    N O N C L U S T E R E D;
NOT:                             N O T;
NULL:                            N U L L;
NULLIF:                          N U L L I F;
OF:                              O F;
OFF:                             O F F;
OFFSETS:                         O F F S E T S;
ON:                              O N;
OPEN:                            O P E N;
OPENDATASOURCE:                  O P E N D A T A S O U R C E;
OPENQUERY:                       O P E N Q U E R Y;
OPENROWSET:                      O P E N R O W S E T;
OPENXML:                         O P E N X M L;
OPTION:                          O P T I O N;
OR:                              O R;
ORDER:                           O R D E R;
OUTER:                           O U T E R;
OVER:                            O V E R;
PERCENT:                         P E R C E N T;
PIVOT:                           P I V O T;
PLAN:                            P L A N;
PRECISION:                       P R E C I S I O N;
PRIMARY:                         P R I M A R Y;
PRINT:                           P R I N T;
PROC:                            P R O C;
PROCEDURE:                       P R O C E D U R E;
PUBLIC:                          P U B L I C;
RAISERROR:                       R A I S E R R O R;
READ:                            R E A D;
READTEXT:                        R E A D T E X T;
RECONFIGURE:                     R E C O N F I G U R E;
REFERENCES:                      R E F E R E N C E S;
REPLICATION:                     R E P L I C A T I O N;
RESTORE:                         R E S T O R E;
RESTRICT:                        R E S T R I C T;
RETURN:                          R E T U R N;
REVERT:                          R E V E R T;
REVOKE:                          R E V O K E;
RIGHT:                           R I G H T;
ROLLBACK:                        R O L L B A C K;
ROWCOUNT:                        R O W C O U N T;
ROWGUIDCOL:                      R O W G U I D C O L;
RULE:                            R U L E;
SAVE:                            S A V E;
SCHEMA:                          S C H E M A;
SECURITYAUDIT:                   S E C U R I T Y A U D I T;
SELECT:                          S E L E C T;
SEMANTICKEYPHRASETABLE:          S E M A N T I C K E Y P H R A S E T A B L E;
SEMANTICSIMILARITYDETAILSTABLE:  S E M A N T I C S I M I L A R I T Y D E T A I L S T A B L E;
SEMANTICSIMILARITYTABLE:         S E M A N T I C S I M I L A R I T Y T A B L E;
SESSION_USER:                    S E S S I O N '_' U S E R;
SET:                             S E T;
SETUSER:                         S E T U S E R;
SHUTDOWN:                        S H U T D O W N;
SOME:                            S O M E;
STATISTICS:                      S T A T I S T I C S;
SYSTEM_USER:                     S Y S T E M '_' U S E R;
TABLE:                           T A B L E;
TABLESAMPLE:                     T A B L E S A M P L E;
TEXTSIZE:                        T E X T S I Z E;
THEN:                            T H E N;
TO:                              T O;
TOP:                             T O P;
TRAN:                            T R A N;
TRANSACTION:                     T R A N S A C T I O N;
TRIGGER:                         T R I G G E R;
TRUNCATE:                        T R U N C A T E;
TRY_CONVERT:                     T R Y '_' C O N V E R T;
TSEQUAL:                         T S E Q U A L;
UNION:                           U N I O N;
UNIQUE:                          U N I Q U E;
UNPIVOT:                         U N P I V O T;
UPDATE:                          U P D A T E;
UPDATETEXT:                      U P D A T E T E X T;
USE:                             U S E;
USER:                            U S E R;
VALUES:                          V A L U E S;
VARYING:                         V A R Y I N G;
VIEW:                            V I E W;
WAITFOR:                         W A I T F O R;
WHEN:                            W H E N;
WHERE:                           W H E R E;
WHILE:                           W H I L E;
WITH:                            W I T H;
WITHIN:                          W I T H I N;
WRITETEXT:                       W R I T E T E X T;

// Additional keywords (they can be id).
ABSOLUTE:                        A B S O L U T E;
APPLY:                           A P P L Y;
AUTO:                            A U T O;
AVG:                             A V G;
BASE64:                          B A S E '64';
CALLER:                          C A L L E R;
CAST:                            C A S T;
CATCH:                           C A T C H;
CHECKSUM_AGG:                    C H E C K S U M '_' A G G;
COMMITTED:                       C O M M I T T E D;
CONCAT:                          C O N C A T;
COOKIE:                          C O O K I E;
COUNT:                           C O U N T;
COUNT_BIG:                       C O U N T '_' B I G;
DELAY:                           D E L A Y;
DELETED:                         D E L E T E D;
DENSE_RANK:                      D E N S E '_' R A N K;
DISABLE:                         D I S A B L E;
DYNAMIC:                         D Y N A M I C;
ENCRYPTION:                      E N C R Y P T I O N;
FAST:                            F A S T;
FAST_FORWARD:                    F A S T '_' F O R W A R D;
FIRST:                           F I R S T;
FOLLOWING:                       F O L L O W I N G;
FORWARD_ONLY:                    F O R W A R D '_' O N L Y;
FULLSCAN:                        F U L L S C A N;
GLOBAL:                          G L O B A L;
GO:                              G O;
GROUPING:                        G R O U P I N G;
GROUPING_ID:                     G R O U P I N G '_' I D;
HASH:                            H A S H;
INSENSITIVE:                     I N S E N S I T I V E;
INSERTED:                        I N S E R T E D;
ISOLATION:                       I S O L A T I O N;
KEEPFIXED:                       K E E P F I X E D;
KEYSET:                          K E Y S E T;
LAST:                            L A S T;
LEVEL:                           L E V E L;
LOCAL:                           L O C A L;
LOCK_ESCALATION:                 L O C K '_' E S C A L A T I O N;
LOGIN:                           L O G I N;
LOOP:                            L O O P;
MARK:                            M A R K;
MAX:                             M A X;
MIN:                             M I N;
MODIFY:                          M O D I F Y;
NEXT:                            N E X T;
NAME:                            N A M E;
NOCOUNT:                         N O C O U N T;
NOEXPAND:                        N O E X P A N D;
NORECOMPUTE:                     N O R E C O M P U T E;
NTILE:                           N T I L E;
NUMBER:                          N U M B E R;
OFFSET:                          O F F S E T;
ONLY:                            O N L Y;
OPTIMISTIC:                      O P T I M I S T I C;
OPTIMIZE:                        O P T I M I Z E;
OUT:                             O U T;
OUTPUT:                          O U T P U T;
OWNER:                           O W N E R;
PARTITION:                       P A R T I T I O N;
PATH:                            P A T H;
PRECEDING:                       P R E C E D I N G;
PRIOR:                           P R I O R;
RANGE:                           R A N G E;
RANK:                            R A N K;
READONLY:                        R E A D O N L Y;
READ_ONLY:                       R E A D '_' O N L Y;
RECOMPILE:                       R E C O M P I L E;
RELATIVE:                        R E L A T I V E;
REMOTE:                          R E M O T E;
REPEATABLE:                      R E P E A T A B L E;
ROOT:                            R O O T;
ROW:                             R O W;
ROWGUID:                         R O W G U I D;
ROWS:                            R O W S;
ROW_NUMBER:                      R O W '_' N U M B E R;
SAMPLE:                          S A M P L E;
SCHEMABINDING:                   S C H E M A B I N D I N G;
SCROLL:                          S C R O L L;
SCROLL_LOCKS:                    S C R O L L '_' L O C K S;
SELF:                            S E L F;
SERIALIZABLE:                    S E R I A L I Z A B L E;
SNAPSHOT:                        S N A P S H O T;
STATIC:                          S T A T I C;
STATS_STREAM:                    S T A T S '_' S T R E A M;
STDEV:                           S T D E V;
STDEVP:                          S T D E V P;
SUM:                             S U M;
THROW:                           T H R O W;
TIES:                            T I E S;
TIME:                            T I M E;
TRY:                             T R Y;
TYPE:                            T Y P E;
TYPE_WARNING:                    T Y P E '_' W A R N I N G;
UNBOUNDED:                       U N B O U N D E D;
UNCOMMITTED:                     U N C O M M I T T E D;
UNKNOWN:                         U N K N O W N;
USING:                           U S I N G;
VAR:                             V A R;
VARP:                            V A R P;
VIEW_METADATA:                   V I E W '_' M E T A D A T A;
WORK:                            W O R K;
XML:                             X M L;
XMLNAMESPACES:                   X M L N A M E S P A C E S;

DOLLAR_ACTION:                   '$' A C T I O N;

SPACE:              [ \t\r\n]+    -> skip;
COMMENT:            '/*' .*? '*/' -> channel(HIDDEN);
LINE_COMMENT:       '--' ~[\r\n]* -> channel(HIDDEN);

// TODO: ID can be not only Latin.
DOUBLE_QUOTE_ID:    '"' ~'"'+ '"';
SQUARE_BRACKET_ID:  '[' ~']'+ ']';
LOCAL_ID:           '@' [a-zA-Z_$@#0-9]+;
DECIMAL:             DEC_DIGIT+;
ID:                  [a-zA-Z_#][a-zA-Z_#$@0-9]*;
STRING:              N? '\'' (~'\'' | '\'\'')* '\'';
BINARY:              '0' X HEX_DIGIT*;
FLOAT:               DEC_DOT_DEC;
REAL:                DEC_DOT_DEC (E [+-]? DEC_DIGIT+)?;

EQUAL:               '=';

GREATER:             '>';
LESS:                '<';
EXCLAMATION:         '!';

PLUS_ASSIGN:         '+=';
MINUS_ASSIGN:        '-=';
MULT_ASSIGN:         '*=';
DIV_ASSIGN:          '/=';
MOD_ASSIGN:          '%=';
AND_ASSIGN:          '&=';
XOR_ASSIGN:          '^=';
OR_ASSIGN:           '|=';

DOT:                 '.';
UNDERLINE:           '_';
AT:                  '@';
SHARP:               '#';
DOLLAR:              '$';
LR_BRACKET:          '(';
RR_BRACKET:          ')';
COMMA:               ',';
SEMI:                ';';
COLON:               ':';
STAR:                '*';
DIVIDE:              '/';
MODULE:              '%';
PLUS:                '+';
MINUS:               '-';
BIT_NOT:             '~';
BIT_OR:              '|';
BIT_AND:             '&';
BIT_XOR:             '^';

fragment LETTER:       [a-zA-Z_];
fragment DEC_DOT_DEC:  (DEC_DIGIT+ '.' DEC_DIGIT+ |  DEC_DIGIT+ '.' | '.' DEC_DIGIT+);
fragment HEX_DIGIT:    [0-9A-Fa-f];
fragment DEC_DIGIT:    [0-9];

fragment A: [aA];
fragment B: [bB];
fragment C: [cC];
fragment D: [dD];
fragment E: [eE];
fragment F: [fF];
fragment G: [gG];
fragment H: [hH];
fragment I: [iI];
fragment J: [jJ];
fragment K: [kK];
fragment L: [lL];
fragment M: [mM];
fragment N: [nN];
fragment O: [oO];
fragment P: [pP];
fragment Q: [qQ];
fragment R: [rR];
fragment S: [sS];
fragment T: [tT];
fragment U: [uU];
fragment V: [vV];
fragment W: [wW];
fragment X: [xX];
fragment Y: [yY];
fragment Z: [zZ];