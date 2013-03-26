package util;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import commands.AndCommand;
import commands.Command;
import commands.DifferenceCommand;
import commands.EqualCommand;
import commands.GreaterCommand;
import commands.IfCommand;
import commands.IfElseCommand;
import commands.LessCommand;
import commands.MinusCommand;
import commands.NotCommand;
import commands.NotEqualCommand;
import commands.OrCommand;
import commands.ProductCommand;
import commands.QuotientCommand;
import commands.RemainderCommand;
import commands.RepeatCommand;
import commands.SumCommand;
import commands.MapCommands.MakeCommand;
import commands.MapCommands.ToCommand;
import commands.TurtleCommands.BackwardCommand;
import commands.TurtleCommands.ClearCommand;
import commands.TurtleCommands.ForwardCommand;
import commands.TurtleCommands.GOTOCommand;
import commands.TurtleCommands.HeadingCommand;
import commands.TurtleCommands.HideTurtleCommand;
import commands.TurtleCommands.HomeCommand;
import commands.TurtleCommands.LeftCommand;
import commands.TurtleCommands.PenDownPCommand;
import commands.TurtleCommands.RightCommand;
import commands.TurtleCommands.SetHeadingCommand;
import commands.TurtleCommands.ShowTurtleCommand;
import commands.TurtleCommands.ShowingCommand;
import commands.TurtleCommands.TellCommand;
import commands.TurtleCommands.TowardsCommand;
import commands.TurtleCommands.XCorCommand;
import commands.TurtleCommands.YCorCommand;
import java.util.ResourceBundle;

public class Grammar {
	private Map<String, Command> myCommandMap;
	private static ResourceBundle myResources;
	private static final String DEFAULT_RESOURCE_PACKAGE = "util.resources.";

	public Grammar(String language) {

		myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE
				+ language);
		myCommandMap = new HashMap<String, Command>();
		Command forward = new ForwardCommand();
		Command repeat = new RepeatCommand();
		Command make = new MakeCommand();
		Command sum = new SumCommand();
		Command back = new BackwardCommand();
		Command to = new ToCommand();
		Command right = new RightCommand();
		Command left = new LeftCommand();
		Command setheading = new SetHeadingCommand();
		Command towards = new TowardsCommand();
		Command and = new AndCommand();
		Command diff = new DifferenceCommand();
		Command equal = new EqualCommand();

		Command minus = new MinusCommand();
		Command not = new NotCommand();
		Command notE = new NotEqualCommand();
		Command or = new OrCommand();
		Command product = new ProductCommand();
		Command quotient = new QuotientCommand();
		Command mod = new RemainderCommand();

		Command ifcommand = new IfCommand();
		Command ifelse = new IfElseCommand();
		Command clear = new ClearCommand();
		Command home = new HomeCommand();
		Command go = new GOTOCommand();
		Command heading = new HeadingCommand();

		Command hide = new HideTurtleCommand();
		Command show = new ShowTurtleCommand();
		Command showing = new ShowingCommand();
		Command pendown = new NotEqualCommand();
		Command penup = new OrCommand();
		Command penstatus = new PenDownPCommand();
		Command xcor = new XCorCommand();
		Command ycor = new YCorCommand();
		Command less = new LessCommand();
		Command greater = new GreaterCommand();
		Command tell = new TellCommand();

		myCommandMap.put(myResources.getString("If").toLowerCase(), ifcommand);
		myCommandMap.put(myResources.getString("Ifelse").toLowerCase(), ifelse);
		myCommandMap.put(myResources.getString("Setxy").toLowerCase(), go);
		myCommandMap.put(myResources.getString("Goto").toLowerCase(), go);
		myCommandMap.put(myResources.getString("Pendown").toLowerCase(),
				pendown);
		myCommandMap.put(myResources.getString("PD").toLowerCase(), pendown);
		myCommandMap.put(myResources.getString("PenUp").toLowerCase(), penup);
		myCommandMap.put(myResources.getString("PU").toLowerCase(), penup);
		myCommandMap.put(myResources.getString("HIDETURTLE").toLowerCase(),
				hide);
		myCommandMap.put(myResources.getString("HT").toLowerCase(), hide);
		myCommandMap.put(myResources.getString("SHOWTURTLE").toLowerCase(),
				show);
		myCommandMap.put(myResources.getString("ST").toLowerCase(), show);
		myCommandMap.put(myResources.getString("HOME").toLowerCase(), home);
		myCommandMap.put(myResources.getString("CLEARSCREEN").toLowerCase(),
				clear);
		myCommandMap.put(myResources.getString("CS").toLowerCase(), clear);
		myCommandMap.put(myResources.getString("HEADING").toLowerCase(),
				heading);
		myCommandMap.put(myResources.getString("XCOR").toLowerCase(), xcor);
		myCommandMap.put(myResources.getString("YCOR").toLowerCase(), ycor);
		myCommandMap.put(myResources.getString("PENDOWN?").toLowerCase(),
				pendown);
		myCommandMap.put(myResources.getString("PENDOWNP").toLowerCase(),
				pendown);
		myCommandMap.put(myResources.getString("SHOWING?").toLowerCase(),
				showing);
		myCommandMap.put(myResources.getString("SHOWINGP").toLowerCase(),
				showing);
		myCommandMap.put(myResources.getString("MINUS").toLowerCase(), minus);
		myCommandMap.put(myResources.getString("~").toLowerCase(), minus);
		myCommandMap.put(myResources.getString("NOT").toLowerCase(), not);
		myCommandMap
				.put(myResources.getString("NOTEQUAL?").toLowerCase(), notE);
		myCommandMap
				.put(myResources.getString("NOTEQUALP").toLowerCase(), notE);
		myCommandMap.put(myResources.getString("OR").toLowerCase(), or);
		myCommandMap.put(myResources.getString("PRODUCT").toLowerCase(),
				product);
		myCommandMap.put(myResources.getString("*").toLowerCase(), product);
		myCommandMap.put(myResources.getString("QUOTIENT").toLowerCase(),
				quotient);
		myCommandMap.put(myResources.getString("/").toLowerCase(), quotient);
		myCommandMap.put(myResources.getString("REMAINDER").toLowerCase(), mod);
		myCommandMap.put(myResources.getString("%").toLowerCase(), mod);
		myCommandMap.put(myResources.getString("GREATER?").toLowerCase(),
				greater);
		myCommandMap.put(myResources.getString("GREATERP").toLowerCase(),
				greater);
		myCommandMap.put(myResources.getString("LESS?").toLowerCase(), less);
		myCommandMap.put(myResources.getString("LESSP").toLowerCase(), less);
		myCommandMap.put(myResources.getString("EQUAL?").toLowerCase(), equal);
		myCommandMap.put(myResources.getString("EQUALP").toLowerCase(), equal);
		myCommandMap.put(myResources.getString("DIFFERENCE").toLowerCase(),
				diff);
		myCommandMap.put(myResources.getString("-").toLowerCase(), diff);
		myCommandMap.put(myResources.getString("AND").toLowerCase(), and);
		myCommandMap.put(myResources.getString("FORWARD").toLowerCase(),
				forward);
		myCommandMap.put(myResources.getString("BACK").toLowerCase(), back);
		myCommandMap.put(myResources.getString("MAKE").toLowerCase(), make);
		myCommandMap.put(myResources.getString("SUM").toLowerCase(), sum);
		myCommandMap.put(myResources.getString("LEFT").toLowerCase(), right);
		myCommandMap.put(myResources.getString("LT").toLowerCase(), left);
		myCommandMap.put(myResources.getString("RT").toLowerCase(), right);
		myCommandMap.put(myResources.getString("TO").toLowerCase(), to);
		myCommandMap.put(myResources.getString("FD").toLowerCase(), forward);
		myCommandMap.put(myResources.getString("BK").toLowerCase(), back);
		myCommandMap.put(myResources.getString("SET").toLowerCase(), make);
		myCommandMap.put(myResources.getString("+").toLowerCase(), sum);
		myCommandMap.put(myResources.getString("LT").toLowerCase(), left);
		myCommandMap.put(myResources.getString("RT").toLowerCase(), right);
		myCommandMap.put(myResources.getString("SETHEADING").toLowerCase(),
				setheading);
		myCommandMap.put(myResources.getString("SETH").toLowerCase(),
				setheading);
		myCommandMap.put(myResources.getString("TOWARDS").toLowerCase(),
				towards);

		myCommandMap.put("PU", penup);
		myCommandMap.put("HIDETURTLE", hide);
		myCommandMap.put("HT", hide);
		myCommandMap.put("SHOWTURTLE", show);
		myCommandMap.put("ST", show);
		myCommandMap.put("HOME", home);
		myCommandMap.put("CLEARSCREEN", clear);
		myCommandMap.put("CS", clear);
		myCommandMap.put("HEADING", heading);
		myCommandMap.put("XCOR", xcor);
		myCommandMap.put("YCOR", ycor);
		myCommandMap.put("PENDOWN?", pendown);
		myCommandMap.put("PENDOWNP", pendown);
		myCommandMap.put("SHOWING?", showing);
		myCommandMap.put("SHOWINGP", showing);
		myCommandMap.put("YCOR", ycor);

		myCommandMap.put("MINUS", minus);
		myCommandMap.put("~", minus);
		myCommandMap.put("NOT", not);
		myCommandMap.put("NOTEQUAL?", notE);
		myCommandMap.put("NOTEQUALP", notE);
		myCommandMap.put("OR", or);
		myCommandMap.put("PRODUCT", product);
		myCommandMap.put("*", product);
		myCommandMap.put("QUOTIENT", quotient);
		myCommandMap.put("/", quotient);
		myCommandMap.put("REMAINDER", mod);
		myCommandMap.put("%", mod);
		myCommandMap.put("GREATER?", greater);
		myCommandMap.put("GREATERP", greater);
		myCommandMap.put("LESS?", less);
		myCommandMap.put("LESSP", less);
		myCommandMap.put("EQUAL?", equal);
		myCommandMap.put("EQUALP", equal);
		myCommandMap.put("DIFFERENCE", diff);
		myCommandMap.put("-", diff);
		myCommandMap.put("AND", and);
		myCommandMap.put("FORWARD", forward);
		myCommandMap.put("BACK", back);
		myCommandMap.put("REPEAT", repeat);
		myCommandMap.put("MAKE", make);
		myCommandMap.put("SUM", sum);
		myCommandMap.put("LEFT", left);
		myCommandMap.put("RIGHT", right);
		myCommandMap.put("LT", left);
		myCommandMap.put("RT", right);
		myCommandMap.put("TO", to);
		myCommandMap.put("FD", forward);
		myCommandMap.put("BK", back);
		myCommandMap.put("SET", make);
		myCommandMap.put("+", sum);
		myCommandMap.put("LT", left);
		myCommandMap.put("RT", right);
		myCommandMap.put("SETHEADING", setheading);
		myCommandMap.put("SETH", setheading);
		myCommandMap.put("TOWARDS", towards);
		myCommandMap.put("tell", tell);
	}

	public Map<String, Command> getMap() {
		return myCommandMap;
	}

}
