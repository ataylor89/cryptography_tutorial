# Cryptography tutorial (part two)

## Introduction

In part one, we introduced the AddSubtract algorithm, and explained it at length.

In part two, we introduce a second algorithm, called Rot13.

Rot13 is short for "rotate by 13 places".

Rot13 rotates the characters of the English alphabet by 13 places.

It leaves all other characters untouched.

You can think of the Unicode character set as an array with 1,114,111 characters.

The characters are indexed 0, 1, 2, ..., 1,114,110.

The index values (0 through 1,114,110) are called code points.

The characters A-Z correspond to the code points [65, 90].

The characters a-z correspond to the code points [97, 122].

Rot13 rotates characters within these two bands (65-90 and 97-122) by 13 places.

The English alphabet has 26 characters, so if you apply Rot13 twice, you get the original message.

This means that Rot13 is its own inverse.

Mathematically, we write, Rot13(Rot13(M)) = M.

Rot13 is not a secure cryptography algorithm (cracking it is trivial) but it's a really valuable educational tool.

Later on, in this tutorial, we will introduce some secure cryptography algorithms, like Xor and Rsa.

## Example usage

    % cd ~/Github/cryptography_tutorial/part2_rot13

    % java Rot13 "hello world today is monday november 2 2026" -o cipher.txt

    % cat cipher.txt
    uryyb jbeyq gbqnl vf zbaqnl abirzore 2 2026

    % java Rot13 -i cipher.txt
    hello world today is monday november 2 2026

    % python rot13.py "hello world today is monday november 2 2026" -o cipher.txt

    % cat cipher.txt
    uryyb jbeyq gbqnl vf zbaqnl abirzore 2 2026

    % python rot13.py -i cipher.txt
    hello world today is monday november 2 2026

    % perl rot13.pl "hello world today is monday november 2 2026" -o cipher.txt

    % cat cipher.txt
    uryyb jbeyq gbqnl vf zbaqnl abirzore 2 2026

    % perl rot13.pl -i cipher.txt
    hello world today is monday november 2 2026

    % ruby rot13.rb "hello world today is monday november 2 2026" -o cipher.txt

    % cat cipher.txt
    uryyb jbeyq gbqnl vf zbaqnl abirzore 2 2026

    % ruby rot13.rb -i cipher.txt
    hello world today is monday november 2 2026
