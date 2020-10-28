package test;

import java.text.MessageFormat;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class testJava {
    private String getHtmlData(String bodyHtml) {
        String head = "<head>" +
                "<meta charset=\"UTF-8\" name=\"viewport\" content=\"width=device-width, initial-scale=1.0, user-scalable=no\"> " +
                "<style>img{max-width:100% !important; width:auto; height:auto;} video  {height:auto; max-width:100% !important;width: 100%;} body{font-size:14px;color:#262626;}  </style>" +
                "</head>";

        String script = "";
        return MessageFormat.format("<html>{0}<body style=\"height:auto;max-width: 100%; width:auto;padding: 0;margin:0\">{1}<script>{2}</script></body></html>", head, bodyHtml, script);
    }


    public static void main(String[] args) {
        System.out.println(new testJava().getHtmlData("1"));
        System.out.println(System.currentTimeMillis());
    }

}


