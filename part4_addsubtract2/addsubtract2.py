import argparse
import base64
import sys

def encrypt(plaintext, key):
    ciphertext = ''
    keylen = len(key)
    for i in range(len(plaintext)):
        character = plaintext[i]
        codepoint = ord(character)
        key_part = key[i % keylen]
        if codepoint + key_part > sys.maxunicode:
            raise ValueError('codepoint + key > sys.maxunicode')
        target = codepoint + key_part
        ciphertext += chr(target)
    bytearr = ciphertext.encode('utf-8')
    encoded_ciphertext = base64.b64encode(bytearr).decode('utf-8')
    return encoded_ciphertext

def decrypt(ciphertext, key):
    plaintext = ''
    decoded_ciphertext = base64.b64decode(ciphertext).decode('utf-8')
    keylen = len(key)
    for i in range(len(decoded_ciphertext)):
        character = decoded_ciphertext[i]
        codepoint = ord(character)
        key_part = key[i % keylen]
        if codepoint - key_part < 0:
            raise ValueError('codepoint - key < 0')
        source = codepoint - key_part
        plaintext += chr(source)
    return plaintext

def main():
    argparser = argparse.ArgumentParser(prog='addsubtract2.py', description='Encrypt or decrypt a message')
    message_group = argparser.add_mutually_exclusive_group(required=True)
    message_group.add_argument('message', type=str, nargs='?')
    message_group.add_argument('-i', '--inputfile', type=str)
    mode_group = argparser.add_mutually_exclusive_group(required=True)
    mode_group.add_argument('-e', '--encrypt', action='store_true')
    mode_group.add_argument('-d', '--decrypt', action='store_true')
    argparser.add_argument('-k', '--key', type=float, nargs='+', default=[10e5])
    argparser.add_argument('-o', '--outputfile', type=str)
    args = argparser.parse_args()
    if args.inputfile:
        with open(args.inputfile, 'r') as file:
            message = file.read()
    else:
        message = args.message
    try:
        key = [int(val) for val in args.key]
    except:
        print('Unable to parse key as a list of integers')
        return 
    if args.encrypt:
        output = encrypt(message, key)
    else:
        output = decrypt(message, key)
    if args.outputfile:
        with open(args.outputfile, 'w') as file:
            file.write(output)
    else:
        print(output, end='')

if __name__ == '__main__':
    main()
