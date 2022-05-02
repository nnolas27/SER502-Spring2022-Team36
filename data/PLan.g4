grammar PLan;


program : 'start' announce_list 'pcode' statement_list 'terminate' ';';

statement_list : statement statement_list
| statement;

statement : assignment_statement ';'
      | display_statement ';'
      | if_statement
      | while_statement
	  | unary_statement ';'
	  | for_statement
	  | for_range_statement
	  | ternary_statement ';'
      | procedure_statement
      | procedure_call_statement ';';


announce_list : announce ';' announce_list
	  | announce ';';
	  
announce : int_announce
      | bool_announce
      | var_announce;
      
var_announce : 'variable' IDENTIFIER ';' ;
      
int_announce : 'int' IDENTIFIER;

bool_announce : 'bool' IDENTIFIER;

assignment_statement : IDENTIFIER '=' exp
				| IDENTIFIER '=' bool_exp;


if_statement : 'start_if' '(' bool_exp ')' ':' statement_list 'end_if' else_statement?;

else_statement : 'start_else' ':' statement_list 'end_else';

while_statement : 'start_while' '(' bool_exp ')' ':' statement_list 'end_while';

for_statement : 'start_for' '(' bool_exp ')' ':' statement_list 'end_for';

for_range_statement : 'start_for'  IDENTIFIER  'in' 'for_range' '('NUMBER ',' NUMBER')'  statement_list |'start_for'  IDENTIFIER  'in' 'for_range' '('NUMBER ',' NUMBER ',' NUMBER ')' statement_list ;

ternary_statement : 'int' IDENTIFIER  '=' conditional_exp '?' exp ':' exp |'bool' IDENTIFIER  '=' conditional_exp '?' BOOLEAN ':' BOOLEAN ;

unary_statement : '++' IDENTIFIER 
| IDENTIFIER '++'                
| '--' IDENTIFIER                
| IDENTIFIER '--'                
;

display_statement : 'display' exp;

procedure_statement : 'proc' IDENTIFIER '('(IDENTIFIER | (IDENTIFIER (',' IDENTIFIER)*))?')' ':' announce_list? statement_list (return_statement)? 'endproc';

return_statement :'return' exp ';';

procedure_call_statement : IDENTIFIER '('(exp | exp (',' exp)*)?')' ;


conditional_exp : exp '==' exp
        | exp '!=' exp
        | exp '<' exp
        | exp '<=' exp
        | exp '>' exp
        | exp '>=' exp
        | exp '==' BOOLEAN
        | exp '!=' BOOLEAN
        | '?' bool_component;
        


bool_exp : conditional_exp
        | bool_component ;


exp : term '+' exp
      | term '-' exp
      | term;
	  

term :  component '*' term
      | component '/' term
      | component '%' term
      | component;


component : '(' exp ')'
    | IDENTIFIER
    | procedure_call_statement
    | NUMBER ;
    
bool_component : IDENTIFIER | BOOLEAN;

BOOLEAN : 'true' | 'false' ;

IDENTIFIER : [a-zA-Z][a-zA-Z0-9]*  ;


NUMBER :[0-9]+;

GAP : [ \t\r\n]+ -> skip ;

COMMENT : '$' ~[\r\n]* -> skip;