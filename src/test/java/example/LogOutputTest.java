package example;

import org.apache.log4j.Appender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggingEvent;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import static org.hamcrest.core.Is.*;
import static org.hamcrest.MatcherAssert.*;

public class LogOutputTest {

    @Mock
    private Appender mockAppender;
    @Captor
    private ArgumentCaptor<LoggingEvent> captorLoggingEvent;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        final Logger logger = Logger.getLogger(LogOutput.class);
        logger.addAppender(mockAppender);
    }

    @Test
    public void outputLogTest() throws Exception {
        LogOutput logOutput = new LogOutput();
        logOutput.outputLog();
        verify(mockAppender).doAppend(captorLoggingEvent.capture());
        final LoggingEvent loggingEvent = captorLoggingEvent.getValue();
        assertThat(loggingEvent.getLevel(), is(Level.ERROR));
        //Check the message being logged is correct
        assertThat(loggingEvent.getMessage(),is("Hello!!"));
    }
}
