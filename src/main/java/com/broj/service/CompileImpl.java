package com.broj.service;

import com.broj.model.CompileRequest;
import com.broj.model.CompileResponse;
import com.broj.service.engine.CompileStatus;
import com.broj.service.engine.Compiler;
import com.broj.service.engine.ProcessBuilderFactory;
import com.broj.util.PathUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by seal on 7/22/2016.
 */
@Service
public class CompileImpl implements Compile {

    private static final Logger logger = LoggerFactory.getLogger(CompileImpl.class);

    @Autowired
    private Compiler compiler;

    @Override
    public CompileResponse compile(CompileRequest request) {
        ProcessBuilder processBuilder = ProcessBuilderFactory.getProcessBuilder(request.getSourceFileType(),
                        PathUtil.fileNameFromPath(request.getSourceFilePath()),
                        request.getUserName());

        CompileStatus status = compiler.compile(processBuilder,
                PathUtil.filePath(request.getSourceFilePath()));

        if (status == CompileStatus.COMPILE_ERROR) {
            return new CompileResponse(CompileStatus.COMPILE_ERROR);
        }
        return new CompileResponse(CompileStatus.COMPILE_SUCCESS);
    }
}