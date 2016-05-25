package com.sauljohnson.lizard;

import junit.framework.TestCase;

import java.io.IOException;

/**
 * Unit tests for the {@link LzwCompressor} class.
 *
 * @version 1.0 25 May 2016
 * @author  Saul Johnson
 */
public class LzwCompressorTests extends TestCase {

    public void testCompress() {
        // Create compressor and data to compress.
        LzwCompressor subject = new LzwCompressor();
        byte[] data = new byte[] {0, 16};

        // Try to compress data.
        try {
            byte[] compressed = subject.compress(data);

            // For a small array this will actually increase the size.
            assertEquals(4, compressed.length);
            assertEquals(16, compressed[3]);
        } catch (IOException ex) {
            fail("Exception encountered during compression.");
        }
    }

    public void testDecompress() {
        // Create compressor and data to decompress.
        LzwCompressor subject = new LzwCompressor();
        byte[] data = new byte[] {0, 0, 0, 16};

        // Try to decompress data.
        try {
            byte[] decompressed = subject.decompress(data);

            // This should actually decrease the size.
            assertEquals(2, decompressed.length);
            assertEquals(0, decompressed[0]);
            assertEquals(16, decompressed[1]);
        } catch (IOException ex) {
            fail("Exception encountered during decompression.");
        }
    }
}
