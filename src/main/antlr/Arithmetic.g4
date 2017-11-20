grammar Arithmetic;

expression returns [double value]
	: t = term					{$value =  $t.value;}
	  ( PLUS t = term		{$value += $t.value;}
	  | MINUS t = term	{$value -= $t.value;}
	  )*
	;

term returns [double value]
	: sa = signedAtom					{$value =  $sa.value;}
	  ( TIMES sa = signedAtom	{$value *= $sa.value;}
	  | DIV sa = signedAtom		{$value /= $sa.value;}
	  )*
	;

signedAtom returns [double value]
	: a = atom							{$value =  $a.value;}
	| PLUS sa = signedAtom	{$value =  $sa.value;}
	| MINUS sa = signedAtom	{$value = -$sa.value;}
	;

atom returns [double value]
	: num = NUMBER										{$value = Double.parseDouble($num.text);}
	| LPAREN exp = expression RPAREN	{$value = $exp.value;}
	;

NUMBER	: ('0' .. '9')* ('.' ('0' .. '9')* )? ;
LPAREN	: '(' ;
RPAREN	: ')' ;
PLUS	: '+' ;
MINUS	: '-' ;
TIMES	: '*'
		| '×' ;
DIV		: '/'
		| '÷' ;
POINT	: '.' ;
WS		: [ \r\n\t] + -> skip ;
