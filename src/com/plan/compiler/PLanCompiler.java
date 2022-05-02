package com.plan.compiler;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class PLanCompiler {

    static PLanParser parser = null;
    public static void main(String[] args) {

        String filename = "";

        if (args.length > 0){
            filename = args[0];
        } else {
            System.out.println(" File parameter cannot be empty");
            return;
        }

        if (!filename.contains(".plan")) {
            System.out.println("Enter a valid file name with .plan extension");
            throw new IllegalArgumentException("extension should be .plan only");      
        }

        CharStream charStream = null;
        try {
            charStream = CharStreams.fromFileName(filename);
        } catch (IOException e) {
            System.out.println("ex");
            e.printStackTrace();
        }


        PLanLexer lexer = new PLanLexer(charStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        parser = new PLanParser(tokenStream);
        ParseTreeWalker.DEFAULT.walk(PLanIntermediateCodeGenerator.getInstance(), parser.program());
        ArrayList<String> intermediateCode = PLanIntermediateCodeGenerator.getInstance().getCode();
        writeIntermediateFile(filename, intermediateCode);

    }

    public static PLanParser getParserInstance() {
        return parser;
    }

    public static void writeIntermediateFile(String fileName, ArrayList<String> intermediateCode) {
        try {
            PrintWriter writer = new PrintWriter(fileName + "int", "UTF-8");
            for (String i:intermediateCode){
                writer.println(i);
            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


}