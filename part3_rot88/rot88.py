#!/usr/bin/env python3

import argparse
import base64

def rot88(message):
    result = ''
    for character in message:
        codepoint = ord(character)
        codepoint = (codepoint + 0x88000) % 0x110000
        result += chr(codepoint)
    return result

def main():
    parser = argparse.ArgumentParser(prog='rot88.py', description='Encrypt or decrypt a message')
    message_group = parser.add_mutually_exclusive_group(required=True)
    message_group.add_argument('message', type=str, nargs='?')
    message_group.add_argument('-i', '--inputfile', type=str)
    mode_group = parser.add_mutually_exclusive_group(required=True)
    mode_group.add_argument('-e', '--encrypt', action='store_true')
    mode_group.add_argument('-d', '--decrypt', action='store_true')
    parser.add_argument('-b64', '--base64', action='store_true')
    parser.add_argument('-o', '--outputfile', type=str)
    args = parser.parse_args()
    if args.inputfile:
        with open(args.inputfile, 'r') as file:
            message = file.read()
    else:
        message = args.message
    if args.base64:
        if args.encrypt:
            ciphertext = rot88(message)
            bytearr = ciphertext.encode('utf-8')
            output = base64.b64encode(bytearr).decode('utf-8')
        else:
            decoded_ciphertext = base64.b64decode(message).decode('utf-8')
            output = rot88(decoded_ciphertext)
    else:
        output = rot88(message)
    if args.outputfile:
        with open(args.outputfile, 'w') as file:
            file.write(output)
    else:
        print(output, end='')

if __name__ == '__main__':
    main()
