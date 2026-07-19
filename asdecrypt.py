import argparse
from addsubtract import decrypt

def main():
    argparser = argparse.ArgumentParser(prog='asdecrypt.py', description='Decrypt a message using the addsubtract algorithm')
    group = argparser.add_mutually_exclusive_group(required=True)
    group.add_argument('-m', '--message', type=str)
    group.add_argument('-i', '--inputfile', type=str)
    argparser.add_argument('-k', '--key', type=float, default=10e5)
    argparser.add_argument('-o', '--outputfile', type=str)
    args = argparser.parse_args()
    if args.inputfile:
        with open(args.inputfile, 'r') as file:
            ciphertext = file.read()
    else:
        ciphertext = args.message
    try:
        key = int(args.key)
    except:
        print('Unable to parse key as an integer')
        return 
    plaintext = decrypt(ciphertext, key)
    if args.outputfile:
        with open(args.outputfile, 'w') as file:
            file.write(plaintext)
    else:
        print(plaintext, end='')

if __name__ == '__main__':
    main()
