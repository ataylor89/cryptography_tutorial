# How to run Python code

## Foreword

This tutorial assumes that you have already installed Python 3, and that the python3 interpreter is already present in your PATH variable. The shell program (zsh or bash) searches your PATH variable for the first directory that contains the python3 interpreter, and uses that directory to build a path to the python3 interpreter. If the shell program can't find a command in your PATH variable, and it can't find the command in your aliases, then it simply says, "command not found". I wanted to make this clear at the beginning of my post, because the tutorial assumes that Python 3 is already installed. Sometimes Python 3 comes pre-installed with your computer. If it didn't come pre-installed with your computer, then you can download it from the python.org website, and install it. You can also find instructions for installing Python 3 on the python.org website.

## Tutorial

I have posted Python code to this [blog](https://artofproblemsolving.com/community/c4848563), specifically in the blog post entitled "Cryptography tutorial", and I thought it would help to give some pointers on how to run Python code.

I can think of at least three ways to run Python code:

1. You can run Python code in a terminal emulator (like Terminal or Command Prompt) using the Python interpreter
2. You can run Python code in an IDE (Integrated Development Environment), which uses the Python interpreter behind the scenes
3. You can run Python code interactively using the Python interpreter's interactive mode

It's important to point out that all three ways that I mentioned involve the Python interpreter.

The Python interpreter is a program that ships with Python. Its job is to interpret and execute Python code. More specifically, it translates Python code to machine code, which then gets executed by the CPU.

The Python interpreter that I use is python3. If you are using a MacBook, like I am, then you can create an alias for python3 in your ~/.zprofile or ~/.zshrc configuration file, pointing the command "python" to "python3".

For example, here are the first two lines of my ~/.zprofile configuration file.

    % head -n 2 ~/.zprofile
    alias python="python3"
    alias pip="pip3"

Now, the title of this post is "How to run Python code". So far I have given three different ways to run Python code. Let's explain each method in detail, with examples.

I am using a MacBook Pro, so my explanation will use macOS terminology. But if you are using Windows or Linux, then you can figure out a similar approach, using Power Shell, Command Prompt, GNOME Terminal, or whatever terminal emulator is native to your system.

On my MacBook, the Finder application is pinned to my dock. I click on Finder, then I navigate to Applications, then I navigate to Utilities, and then I click on Terminal. This is the main terminal emulator for macOS.

What is a terminal emulator? This is a really good question.

A terminal emulator is a program that emulates the video terminals that were used in the 50s, 60s, and 70s, like the VT100.

Programmers used to connect a video terminal (like the VT100) to a mainframe, and use the terminal to interact with the mainframe.

In fact, the video terminal interacted with a program on the mainframe called the "shell".

The "shell" program received input from the video terminal, and returned output that could be displayed on the video terminal's screen.

You can see that macOS adopted this terminology. The Terminal application is a terminal emulator. The commands that we type in Terminal get interpreted by a shell program (like zsh or bash) and then the output gets displayed in our Terminal window.

I like to say that an analogy is a comparison. (I define metaphors in the same way.) There is a close analogy between the macOS Terminal application and the VT100 video terminals that were used in the 1950s, 1960s, and 1970s.

I think the digression is very helpful, because it helps explain the inner workings of the macOS Terminal application.

Now let's return to the main subject of this post.

After opening the Terminal application, you should see it appear in your Dock as an icon.

You can right-click on the Terminal icon, navigate to Options, and then select "Keep in Dock", so that it's checked.

Once it's checked, it should appear in your Dock every time you log in or unlock your screen.

Now I'm going to navigate to the directory that contains my cryptography tutorial, using the "cd" command in Terminal.

    % cd ~/Github/cryptography_tutorial 
    % ls
    __pycache__	addsubtract.py	README.md

You can see that the directory contains the files in my Github repository (addsubtract.py and README.md).

Now let's run the code in addsubtract.py using the Python interpreter.

(We are using the first method, running Python code in a terminal emulator, to run the code.)

    % python3 addsubtract.py
    Message:
    hello world! it is thursday july 9 2026

    Encrypted message:
    8JiciPCYnIXwmJyM8JicjPCYnI/wmJuA8Jicl/CYnI/wmJyS8JicjPCYnITwmJuB8JibgPCYnInwmJyU8JibgPCYnInwmJyT8JibgPCYnJTwmJyI8JiclfCYnJLwmJyT8JichPCYnIHwmJyZ8JibgPCYnIrwmJyV8JicjPCYnJnwmJuA8JibmfCYm4DwmJuS8JibkPCYm5LwmJuW

    Decrypted message:
    hello world! it is thursday july 9 2026

I used the command "python3", instead of my alias "python", in case the reader has not set up an alias.

You can see that the message is "hello world! it is thursday july 9 2026" (because I wrote it on that day).

The encrypted message is a base64-encoded string. (If we were to decode it, then it would be a series of unprintable characters.)

The decrypted message is the same as our original message.

So we used the "python3" command to run a Python script in Terminal.

Note that we navigated to the directory of the script, before running the script. The directory for me is ~/Github/cryptography_tutorial. It might be different for you. The ~ is shorthand for my user directory.

I'm not going to demonstrate the second method, running Python code in an IDE, in this blog post.

Personally, I like to write Python code in Terminal, using vim, and I like to run Python code in Terminal.

But I will talk about using the Python interpreter in interactive mode.

Interactive mode is very useful, and I thought it would help to cover this subject.

Let's use the Python interpreter in interactive mode.

I am still using the same Terminal session, and its current directory is ~/Github/cryptography_tutorial.

I am going to type the following command in my Terminal window.

    % python3
    Python 3.14.2 (v3.14.2:df793163d58, Dec  5 2025, 12:18:06) [Clang 16.0.0 (clang-1600.0.26.6)] on darwin
    Type "help", "copyright", "credits" or "license" for more information.
    >>> 

I started the Python interpreter in interactive mode using the command "python3".

Now we can import our addsubtract.py module, and use the encrypt and decrypt functions, interactively.

    >>> import addsubtract
    >>> plaintext = 'We are using the Python interpreter in interactive mode'
    >>> key=3*10**5
    >>> ciphertext = addsubtract.encrypt(plaintext, key)
    >>> ciphertext
    '8YmQt/GJkYXxiZCA8YmRgfGJkZLxiZGF8YmQgPGJkZXxiZGT8YmRifGJkY7xiZGH8YmQgPGJkZTxiZGI8YmRhfGJkIDxiZCw8YmRmfGJkZTxiZGI8YmRj/GJkY7xiZCA8YmRifGJkY7xiZGU8YmRhfGJkZLxiZGQ8YmRkvGJkYXxiZGU8YmRhfGJkZLxiZCA8YmRifGJkY7xiZCA8YmRifGJkY7xiZGU8YmRhfGJkZLxiZGB8YmRg/GJkZTxiZGJ8YmRlvGJkYXxiZCA8YmRjfGJkY/xiZGE8YmRhQ=='
    >>> decrypted = addsubtract.decrypt(ciphertext, key)
    >>> decrypted
    'We are using the Python interpreter in interactive mode'

Voilà! It works. We were able to use the encrypt and decrypt functions in interactive mode.

Instead of having to type out "addsubtract.encrypt" and "addsubtract.decrypt", we can import the methods directly.

    >>> from addsubtract import encrypt, decrypt
    >>> plaintext = 'We are using the Python interpreter in interactive mode'
    >>> key=3*10**5
    >>> ciphertext = encrypt(plaintext, key)
    >>> decrypted = decrypt(ciphertext, key)
    >>> decrypted
    'We are using the Python interpreter in interactive mode'

Sometimes, I import methods directly, so that I don't have to type out the module name as a prefix.

We have come a long way... we have now demonstrated two ways of running Python code.

We can run a Python script or a Python program by passing it to the Python interpreter, in a terminal emulator.

We can also run Python code interactively, using interactive mode, in a terminal emulator.

In addition, we have explained some of the terms that we used, like "terminal emulator", "shell", "Terminal", et cetera.

A terminal emulator is just a program that emulates (mimics) the video terminals from the 1950s, 1960s, and 1970s, like the VT100.

The creators of Terminal drew a close analogy between the Terminal application and the VT100 video terminal.

I do everything in Terminal. I write code in Terminal, using vim. I run code in Terminal, by using an interpreter (like python3 or java) or by executing a binary file directly. (After you compile and link a C file to an executable, you can run it directly in Terminal.)

I also write my Github READMEs in Terminal, using vim.

I also upload code to my Github, in Terminal, using the git command-line program.

I ssh into a server, in Terminal, using the ssh program.

So you can see that I do everything in Terminal.

If I'm not using Terminal, then I'm probably using my web browser.

Terminal and my web browser are the two applications that I use the most.

Now, I'd like to return to the main subject of this blog post.

The blog post is entitled "How to run Python code".

We have talked about two ways of running Python code:

1. You can run Python code, in a terminal emulator (like the macOS Terminal application), by passing a Python script or a Python program to the python3 interpreter.
2. You can run Python code, in a terminal emulator (like the macOS Terminal application), interactively, by starting the python3 interpreter in interactive mode, and executing Python commands on the command-line.

We have discussed both methods of running Python code, in detail.

Having done so, I think I have run out of things to talk about.

I don't want to leave the scope of this tutorial.

I'll point out that interactive mode is really useful... especially for testing and problem-solving.

This blog post talks about how to run Python code. Maybe in another post I'll talk about how to run Java code or C/C++ code.

I wish everyone a nice weekend. It is Saturday, July 18, 2026.

I might watch an episode of The Legend of Korra today.

I also have to finish an assignment for work that is due Monday.

Wish me luck. Thanks for reading,  
Andrew
