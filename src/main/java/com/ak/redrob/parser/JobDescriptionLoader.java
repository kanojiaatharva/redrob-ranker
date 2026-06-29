package com.ak.redrob.parser;

import com.ak.redrob.model.JobDescription;

import java.io.IOException;
import java.nio.file.Path;

public interface JobDescriptionLoader {

    JobDescription load(Path path) throws IOException;

}