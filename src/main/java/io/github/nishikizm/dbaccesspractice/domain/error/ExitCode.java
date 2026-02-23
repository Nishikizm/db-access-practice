package io.github.nishikizm.dbaccesspractice.domain.error;

public enum ExitCode {

    SUCCESS(0, "処理完了"), 
    INVALID_ARG_ERROR(1, "引数が不正です"), 
    SQL_ERROR(2, "DBエラーが発生しました");

    private final int id;
    private final String message;

    private ExitCode(int id, String message) {
        this.id = id;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public String message() {
        return message;
    }

}
