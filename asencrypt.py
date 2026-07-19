import argparse
from addsubtract import encrypt

def main():
    argparser = argparse.ArgumentParser(prog='asencrypt.py', description='Encrypt a message using the addsubtract algorithm')
    group = argparser.add_mutually_exclusive_group(required=True)
    group.add_argument('-m', '--message', type=str)
    group.add_argument('-i', '--inputfile', type=str)
    argparser.add_argument('-k', '--key', type=float, default=10e5)
    argparser.add_argument('-o', '--outputfile', type=str)
    args = argparser.parse_args()
    if args.inputfile:
        with open(args.inputfile, 'r') as file:
            plaintext = file.read()
    else:
        plaintext = args.message
    try:
        key = int(args.key)
    except:
        print('Unable to parse key as an integer')
        return 
    ciphertext = encrypt(plaintext, key)
    if args.outputfile:
        with open(args.outputfile, 'w') as file:
            file.write(ciphertext)
    else:
        print(ciphertext, end='')

if __name__ == '__main__':
    main()
