package parser;

import objects.Play;

public interface PlayReader {
    Play read(String uri);
}
