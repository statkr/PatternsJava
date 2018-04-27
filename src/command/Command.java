package command;

import factory.Student;

import java.io.IOException;
import java.io.OutputStream;

public interface Command {
    void print(OutputStream stream) throws IOException;
}
