#!/usr/bin/env python3

import argparse
import base64

def xor(message, key):
    buffer = []
    msglen = len(message)
    keylen = len(key)
    for i in range(msglen):
        m = ord(message[i])
        k = ord(key[i % keylen])
        buffer.append(chr(m ^ k))
    result = ''.join(buffer)
    return result

def main():
    arg_parser = argparse.ArgumentParser(prog='xor.py', description='XOR encryption')
    message_group = arg_parser.add_mutually_exclusive_group(required=True)
    message_group.add_argument('message', type=str, nargs='?')
    message_group.add_argument('-if', '--inputfile', type=str)
    mode_group = arg_parser.add_mutually_exclusive_group(required=False)
    mode_group.add_argument('-e', '--encrypt', action='store_true')
    mode_group.add_argument('-d', '--decrypt', action='store_true')
    arg_parser.add_argument('-b64', '--base64', action='store_true')
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
            return
    if args.base64:
        if args.encrypt:
            encrypted_message = xor(message, key)
            bytearr = encrypted_message.encode('utf-8')
            output = base64.b64encode(bytearr).decode('utf-8')
        elif args.decrypt:
            decoded_message = base64.b64decode(message).decode('utf-8')
            output = xor(decoded_message, key)
        else:
            arg_parser.error('A direction is required for base64 encoding')
    else:
        output = xor(message, key)
    if args.outputfile:
        with open(args.outputfile, 'w') as file:
            file.write(output)
    else:
        print(output, end='')

if __name__ == '__main__':
    main()
