package io.github.nishikizm.dbaccesspractice;

import io.github.nishikizm.dbaccesspractice.domain.error.ExitCode;


public class App {
    public static void main( String[] args ) {

        if(args.length == 0) {
            System.err.println("引数を正しく指定してください");
            System.exit(1);
        }

    }

    private static void endApplication(ExitCode error) {
        
    }

}
