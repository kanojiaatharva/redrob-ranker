package com.ak.redrob.parser;

import com.ak.redrob.model.JobDescription;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class JobDescriptionLoaderTest {

    @Test
    void shouldLoadJobDescription() throws Exception {

        Path jd = Files.createTempFile("jd", ".txt");

        Files.writeString(jd, "Senior AI Engineer");

        JobDescriptionLoader loader =
                new JobDescriptionLoader();

        JobDescription description =
                loader.load(jd);

        assertNotNull(description);

        assertFalse(description.requiredSkills().isEmpty());

        assertEquals(5,
                description.requiredYearsMin());

    }

    @Test
    void shouldThrowWhenFileMissing() {

        JobDescriptionLoader loader =
                new JobDescriptionLoader();

        assertThrows(
                Exception.class,
                () -> loader.load(Path.of("abc.txt"))
        );

    }

}