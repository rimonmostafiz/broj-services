package com.broj.service.engine;

import com.broj.service.CompileStatus;

/**
 * Created by seal on 7/22/2016.
 */
public interface Compiler {

    CompileStatus compile(ProcessBuilder processBuilder, String fileLocation);

    CompileStatus execute(ProcessBuilder processBuilder, String fileLocation,
                          String inputFilePath, String outputFilePath,
                          long timeInMillis);
}
