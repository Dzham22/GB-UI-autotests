package LessonFore.Extentions;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestTime implements AfterTestExecutionCallback, BeforeTestExecutionCallback {
    private static final Logger logger = LoggerFactory.getLogger(TestTime.class);


    @Override
    public void beforeTestExecution(ExtensionContext extensionContext) throws Exception {
        long startTime = System.currentTimeMillis();
        extensionContext.getStore(ExtensionContext.Namespace.GLOBAL).put("start time", System.currentTimeMillis());
        logger.info("Start test: " + extensionContext.getDisplayName());
    }

    @Override
    public void afterTestExecution(ExtensionContext extensionContext) {
        long endTime = System.currentTimeMillis();
        long startTime = (long) extensionContext.getStore(ExtensionContext.Namespace.GLOBAL).get("start time");
        logger.info("End test: " + extensionContext.getDisplayName() + ". Duration " + (endTime - startTime + " ms"));
    }

}
