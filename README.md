# Lizard
Lempel–Ziv–Welch data compression Maven package for Java.

Lizard is a compression library designed to apply LZW compression over byte arrays. When you need to squeeze some data down to a smaller size (for transmission over a network, for example) LZW is a good choice in a pinch. It'll give you a smaller byte array (usually) and you won't need to transfer any kind of lookup table along with your data for decompression (like you would with [Huffman coding](https://github.com/lambdacasserole/huff) for instance).

## Specifications
The term "LZW compression" is pretty vague. More specifically, Lizard:
+ Uses fixed-length, 16-bit codes.
+ Clears the dictionary as soon as it becomes full.

## Installation
You can pull this package into your Maven project straight from here using JitPack. Add JitPack as a repository first:

```
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

Then add a dependency on Lizard:

```
<dependencies>
    <dependency>
        <groupId>com.github.lambdacasserole</groupId>
        <artifactId>lizard</artifactId>
        <version>v1.0</version>
    </dependency>
</dependencies>
```

## Limitations
Lizard won't produce archive files out-of-the-box. It's a lower-level tool for dealing with LZW compression directly. It is not optimized for speed, memory efficiency or performance. This is a naïve implementation and *oh boy is it slow*. Seriously, I literally use hexadecimal strings to build dictionary entries (yeah, I know). Note also that the code dictionary is cleared as soon as it becomes full. This creates a way-less-than-optimal compression ratio.

## Benchmarks
Once again, this package isn't designed for straight-up file compression out of the box. If you do use it for that, however, here are some benchmarks running against the [Canterbury Corpus](http://corpus.canterbury.ac.nz/). Times are for a 1.58GHz x64 CPU with 4GB available RAM.

| File         | Uncompressed (Bytes) | Compressed (Bytes) | Ratio | Space Saving | Time (ms) |
|--------------|----------------------|--------------------|-------|--------------|-----------|
| alice29.txt  | 152089               | 74148              | 2.05  | 51%          | 506.3     |
| asyoulik.txt | 125179               | 62748              | 1.99  | 50%          | 183.8     |
| cp.html      | 24603                | 14948              | 1.65  | 39%          | 17.2      |
| fields.c     | 11150                | 7084               | 1.57  | 36%          | 11.9      |
| grammar.lsp  | 3721                 | 2818               | 1.32  | 24%          | 2.5       |
| kennedy.xls  | 1029744              | 339080             | 3.03  | 67%          | 1608.1    |
| lcet10.txt   | 426754               | 203626             | 2.10  | 52%          | 556.0     |
| plrabn12.txt | 481861               | 243968             | 1.98  | 49%          | 771.5     |
| ptt5         | 513216               | 72850              | 7.04  | 86%          | 1127.4    |
| sum          | 38240                | 25054              | 1.53  | 34%          | 88.6      |
| xargs.1      | 4227                 | 3584               | 1.18  | 15%          | 2.5       |

## Contributing
For most intents and purposes, Lizard is considered to fulfil its original use case. Bug fixes and suggestions are welcome, however, from any member of the community.
