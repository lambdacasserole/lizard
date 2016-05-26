# Lizard
Lempel–Ziv–Welch data compression Maven package for Java.

Lizard is a compression library designed to apply LZW compression over byte arrays. When you need to squeeze some data down to a smaller size (for transmission over a network, for example) LZW is a good choice in a pinch. It'll give you a smaller byte array (usually) and you won't need to transfer any kind of lookup table along with your data for decompression (like you would with [Huffman coding](https://github.com/lambdacasserole/huff) for instance).

## Limitations
Lizard won't produce archive files out-of-the-box. It's a lower-level tool for dealing with LZW compression directly. It is not optimized for speed, memory efficiency or performance. This is a naïve implementation and *oh boy is it slow*. Seriously, I literally use hexadecimal strings to build dictionary entries (yeah, I know). Note also that the code dictionary is cleared as soon as it becomes full. This creates a way-less-than-optimal compression ratio.
