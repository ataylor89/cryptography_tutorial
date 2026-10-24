#!/usr/bin/env python3
import argparse

table = {}
ord_a = ord('a')
ord_A = ord('A')

for i in range(0, 26):
    table[ord_a + i] = ord_a + (i + 13) % 26
    table[ord_A + i] = ord_A + (i + 13) % 26

def rot13(message):
    return message.translate(table)

if __name__ == '__main__':
    parser = argparse.ArgumentParser(prog='rot13.py', description='Encrypt or decrypt a message using rot13')
    group = parser.add_mutually_exclusive_group(required=True)
    group.add_argument('message', type=str, nargs='?')
    group.add_argument('-i', '--inputfile', type=str)
    parser.add_argument('-o', '--outputfile', type=str)
    args = parser.parse_args()
    if args.inputfile:
        with open(args.inputfile, 'r') as file:
            message = file.read()
    else:
        message = args.message
    output = rot13(message)
    if args.outputfile:
        with open(args.outputfile, 'w') as file:
            file.write(output)
    else:
        print(output, end='')
