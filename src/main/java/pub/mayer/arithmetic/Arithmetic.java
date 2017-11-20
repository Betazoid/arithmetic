package pub.mayer.arithmetic;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;

import pub.mayer.arithmetic.ArithmeticParser.ExpressionContext;

public class Arithmetic {

	public Double evaluate(String string) {
		CharStream charStream = new ANTLRInputStream(string);
		ArithmeticLexer arithmeticLexer = new ArithmeticLexer(charStream);
		CommonTokenStream tokenStream = new CommonTokenStream(arithmeticLexer);
		ArithmeticParser arithmeticParser = new ArithmeticParser(tokenStream);
		ExpressionContext expression = arithmeticParser.expression();
		return expression.value;
	}

}
