package io.github.nishikizm.dbaccesspractice;

import io.github.nishikizm.dbaccesspractice.presentation.Dispatcher;
import io.github.nishikizm.dbaccesspractice.domain.error.ExitCode;


public class App {
    public static void main( String[] args ) {

        if(args.length == 0) {
            endApplication(ExitCode.INVALID_ARG_ERROR);
        }

        Dispatcher dispatcher = new Dispatcher();
        endApplication(dispatcher.dispatch(args));

    }

    private static void endApplication(ExitCode error) {
        System.out.println(error.getMessage());
        System.exit(error.getId());
    }

}
