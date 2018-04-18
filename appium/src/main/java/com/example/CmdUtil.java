package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Cmd命令工具类
 *
 * @author eva
 * @date 2017/5/15
 */

public class CmdUtil {

    private static CmdUtil cmdUtil;
    private Runtime runtime = Runtime.getRuntime();

    public static CmdUtil getInstance() {
        if (cmdUtil == null) {
            cmdUtil = new CmdUtil();
        }
        return cmdUtil;
    }

    /**
     * 执行CMD命令
     *
     * @param command
     * @return
     */
    public List<String> execCmd(String command) {
        if (command != null && command != "") {
            BufferedReader br = null;

            try {
                // 执行cmd命令
                Process process = runtime.exec(command);
                br = new BufferedReader(new InputStreamReader(process.getInputStream(), "GBK"));
                String line = "";

                List<String> content = new ArrayList<>();
                while ((line = br.readLine()) != null) {
                    if (line != "") {
                        content.add(line);
                    }
                }

                return content;
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("execCmd执行命令错误!" + e.getMessage());
            } finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return null;
    }

    /**
     * 执行cmd命令看看有没有成功执行
     * @param command 对应的命令
     * @return
     */
    public Boolean execCmdTrue(String command){
        try {
            //执行cmd命令
            Process process = runtime.exec("cmd /c " + command);
            //process.waitFor();
            //process.destroy();
            return true;
        } catch (Exception e) {
            System.out.println("execCmdTrue的cmd命令执行错误" + e.getMessage());
            return false;
        }
    }


}
