import sys
import base64

modulus = sys.maxunicode + 1

def encrypt(plaintext, key):
    ciphertext = ''
    for character in plaintext:
        codepoint = ord(character)
        if codepoint + key >= modulus:
            raise ValueError('Either the message or the key needs to be adjusted')
        target = codepoint + key
        ciphertext += chr(target)
    # print('Ciphertext:\n%s\n' %ciphertext)
    bytearr = ciphertext.encode('utf-8')
    encoded_ciphertext = base64.b64encode(bytearr).decode('utf-8')
    return encoded_ciphertext

def decrypt(ciphertext, key):
    plaintext = ''
    decoded_ciphertext = base64.b64decode(ciphertext).decode('utf-8')
    for character in decoded_ciphertext:
        codepoint = ord(character)
        if codepoint - key < 0:
            raise ValueError('Either the message or the key needs to be adjusted')
        source = codepoint - key
        plaintext += chr(source)
    return plaintext

if __name__ == '__main__':
    message = 'hello world! it is thursday july 9 2026'
    key = 10**5
    print('Message:\n%s\n' %message)
    encrypted_message = encrypt(message, key)
    print('Encrypted message:\n%s\n' %encrypted_message)
    decrypted_message = decrypt(encrypted_message, key)
    print('Decrypted message:\n%s' %decrypted_message)
