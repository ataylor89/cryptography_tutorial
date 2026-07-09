# Cryptography tutorial

## Introduction

I have been thinking about creating a cryptography tutorial for some time. I finally got around to it today. I created a new repository on my Github and I uploaded the first file, [addsubtract.py](https://github.com/ataylor89/cryptography_tutorial/blob/main/addsubtract.py).

I think that this file does a good job of teaching some of the basics of cryptography.

We have two functions, encrypt and decrypt.

The encrypt function takes a plaintext message and a numeric key, and it outputs an encrypted message (often called ciphertext). The decrypt function takes an encrypted message (ciphertext) and a numeric key, and it outputs a plaintext message.

In other words, encrypt(plaintext, key) -> ciphertext and decrypt(ciphertext, key) -> plaintext.

How does it work?

It converts each Unicode character to its Unicode code point. (If you've heard of ASCII, ASCII is a subset of Unicode. In fact, ASCII makes up the first 128 or 256 characters of Unicode, depending on whether you are referring to simple ASCII or extended ASCII. We can't write Arabic or Russian or Mandarin using ASCII, but I think we can write in these languages using Unicode. Unicode has over 1 million code points. I'm not sure if all 1 million code points are used, but a lot of them are, so it's a really big code space.)

Then, it adds the numeric key to the codepoint. This gives us a target codepoint.

After that, it converts the target codepoint to a Unicode character.

By repeating this process over and over for each character in the message, and concatenating the ciphertext in a ciphertext variable, we get a variable that holds the ciphertext for our message.

But if we actually print the ciphertext to the screen, it will look like a jumble of printable and unprintable characters. In fact, it's even possible that all of the characters will be unprintable. We want our ciphertext to include printable characters and only printable characters.

How can we achieve this?

Well a common solution is to encode the ciphertext in base64. Then the output will use the base64 character set.

Encoding is different than encryption.

Encoding is meant to be reversed. It's easy to decode base64 encoded text.

Encryption, on the other hand, is only meant to be reversed by a trusted party that holds your decryption key.

So we encode the ciphertext in base 64, and we get an output that looks very professional.

Here is the code (copy/pasted from the file that I made).

    import sys
    import base64

    def encrypt(plaintext, key):
        ciphertext = ''
        for character in plaintext:
            codepoint = ord(character)
            if codepoint + key > sys.maxunicode:
                raise ValueError('codepoint + key > sys.maxunicode')
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
                raise ValueError('codepoint - key < 0')
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

You can find the code [here](https://github.com/ataylor89/cryptography_tutorial/blob/main/addsubtract.py).

I named the file "addsubtract" because it's a concise name for the encryption and decryption algorithms that I used.

To encrypt a message, we use addition. To decrypt, we use subtraction.

You can see that I created my own encryption and decryption algorithms on the fly.

Anyone can do this -- it's really fun to come up with our own encryption algorithms.

To decrypt my encrypted messages, you need to know my encryption key.

In the example I gave, the encryption key is 10**5, or 100,000.

You might argue that it's easy to crack my encryption algorithm. I would agree with you. It is.

But you can actually choose a key that's hard to guess. You can choose a key that's hard to brute force.

RSA keys, for example, are hard to brute force, especially if you choose large enough prime numbers.

(The typical RSA key is based on two prime numbers that are 100 digits long or 200 digits long or even longer!)

You can actually find the original publication of the RSA cryptography algorithm [here](https://people.csail.mit.edu/rivest/Rsapaper.pdf).

The RSA algorithm uses advanced high school math. You don't need to know abstract algebra, real analysis, or topology to understand the research publication. It uses modular arithmetic and some important theorems from the theory of prime numbers.

I had a very good time learning the RSA algorithm. I wrote an open-source implementation on my Github.

Some people like to solve a problem on their own, as opposed to looking up the solution.

I try to solve a problem on my own, and if I can't solve it, then I often look up the solution.

So I won't post my implementation of the RSA algorithm here.

But I thought it would be very helpful to post a tutorial on cryptography.

The addsubtract algorithm that I created is simple enough that I felt comfortable sharing it.

If you're interested in learning more, you can read the RSA publication that I linked to, and learn how to implement the RSA encryption algorithm. RSA is an asymmetric key algorithm, since the encryption and decryption keys are different. You can also learn how to implement the XOR encryption algorithm. XOR is a symmetric key algorithm, since the encryption and decryption keys are the same.
