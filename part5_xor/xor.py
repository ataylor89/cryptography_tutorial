#!/usr/bin/env python3

import argparse
import base64
import sys

def encrypt(plaintext, key):
    codepoints = list(map(lambda x: ord(x), plaintext))
    num_codepoints = len(codepoints)
    key_parts = list(map(lambda x: ord(x), key))
    keylen = len(key_parts)
    ciphers = [codepoints[i] ^ key_parts[i % keylen] for i in range(num_codepoints)]
    ciphers = [chr(cipher) for cipher in ciphers]
    bytearr = ''.join(ciphers).encode('utf-8')
    ciphertext = base64.b64encode(bytearr).decode('utf-8')
    return ciphertext

def decrypt(ciphertext, key):
    ciphertext = base64.b64decode(ciphertext).decode('utf-8')
    ciphers = list(map(lambda x: ord(x), ciphertext))
    num_ciphers = len(ciphers)
    key_parts = list(map(lambda x: ord(x), key))
    keylen = len(key)
    codepoints = [ciphers[i] ^ key_parts[i % keylen] for i in range(num_ciphers)]
    plaintext = [chr(codepoint) for codepoint in codepoints]
    plaintext = ''.join(plaintext)
    return plaintext

if __name__ == '__main__':
    arg_parser = argparse.ArgumentParser(prog='xor.py', description='XOR encryption')
    message_group = arg_parser.add_mutually_exclusive_group(required=True)
    message_group.add_argument('message', type=str, nargs='?')
    message_group.add_argument('-if', '--inputfile', type=str)
    mode_group = arg_parser.add_mutually_exclusive_group(required=True)
    mode_group.add_argument('-e', '--encrypt', action='store_true')
    mode_group.add_argument('-d', '--decrypt', action='store_true')
    key_group = arg_parser.add_mutually_exclusive_group(required=True)
    key_group.add_argument('-k', '--key', type=str)
    key_group.add_argument('-kf', '--keyfile', type=str)
    arg_parser.add_argument('-of', '--outputfile', type=str)
    args = arg_parser.parse_args()
    if args.inputfile:
        with open(args.inputfile, 'r') as file:
            message = file.read()
    else:
        message = args.message
    if args.key:
        key = args.key
    else:
        try:
            with open(args.keyfile, 'r') as file:
                key = file.read()
        except Exception as err:
            print(err)
            sys.exit(1)
    if args.encrypt:
        output = encrypt(message, key)
    else:
        output = decrypt(message, key)
    if args.outputfile:
        with open(args.outputfile, 'w') as file:
            file.write(output)
    else:
        print(output, end='')
