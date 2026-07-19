# vim tutorial

Hello! Good evening. It's Saturday night and I am currently watching a sports game and listening to music while writing this.

I really enjoy watching sports games. I watch basketball, baseball, football, soccer, tennis, volleyball, billiards, pool, bowling, ice hockey, poker, golf, pickleball, chess, and other games and sports on TV or on the internet.

Now the subject of this post is "vim tutorial".

What is vim, you might ask?

We can actually open Terminal again, just like last time, and see what the man pages have to say. (Man is short for manual, here.)

Finder is pinned to my Dock. Terminal is too. But just in case Terminal isn't pinned to your dock, yet, we can open Finder, navigate to Applications, navigate to Utilities, and click on Terminal. You should see a Terminal icon appear in your dock. It looks like the black screen of a video terminal. You can right-click on the icon, go to Options, and select "Keep in Dock", if you want.

Now, with your Terminal window in focus, which you can always bring back to focus by clicking on the icon in the Dock, type the command "man vim". This brings up the man pages (manual pages) for vim.

I typed "man vim" in Terminal. The man pages for vim are really useful. You can see, under the Name section, that it says "vim - Vi IMproved, a programmer's text editor". The word "vim" stands for "Vi IMproved". It is actually the successor to the text editor vi.

It calls itself a programmer's text editor. This is a nice description of vim.

The description section has a lot of useful information. It says that "[vim] is especially useful for editing programs." It also recommends using the :help command to get help from the online help system.

If you scroll down, there's a whole section on the online help system. There is also a Files section, which mentions important files, like the ~/.vimrc file, which contains your personal Vim initializations.

In addition, the See Also section mentions vimtutor. Vimtutor is another great resource, in addition to the man pages. You can type the command "vimtutor" in Terminal to bring up a vim tutorial. The vimtutor program typically comes pre-installed with macOS.

Now, let's return to the subject of the post. (I say this a lot.)

The man pages are useful. The "vimtutor" program, which comes pre-installed with macOS, is also useful.

But I wanted to write my own tutorial.

(I should mention that there are many useful tutorials on the internet, too.)

So, if I were to begin a tutorial on vim, which I am doing right now, how would I start?

I would start by saying that vim is a text editor that you can use to write source code, plain text files, or any kind of text file.

For example, I write Python code, Java code, C code, C++ code, assembly code, HTML code, JavaScript code, CSS code, Markdown code, SQL code, and all kinds of code in vim. I also write plain text files in vim.

Now, vim is technically the successor to vi, but the two words are often used interchangeably.

(These days, I think that vi is an alias for vim.)

Let's move on.

I like to say that vim has two or three modes: insert mode, command mode, and normal mode.

I say "two or three modes" because some people say that normal mode is part of command mode.

There's a two-mode division of vim (insert mode and command mode) as well as a three-mode division (insert mode, command mode, and normal mode).

I am going to "cd" into my ~/Github/cryptography_tutorial directory. Then we'll launch vim.

    % cd ~/Github/cryptography_tutorial
    % ls
    __pycache__			how_to_run_python_code.md
    addsubtract.py		README.md

The "ls" command tells us that we're in the right directory. (We see all the files we expect to see.) Now let's launch vim.

    % vi

As soon as we run the "vi" command, we see a screen that says "VIM - Vi IMproved".

This is good. This is what we want to see.

The "vim" program always starts in normal mode or command mode, depending on which term you want to use.

It does not start in insert mode. To get to insert mode, you can type "i" or "a" on your keyboard.

Try doing that. After you type "i" or "a" on your keyboard, you see the text "-- INSERT --" appear in the lower left corner of the screen.

The text "-- INSERT --" should be present in the lower left corner of your screen, as long as you are in insert mode.

In fact, it's an indicator that tells you you're in insert mode.

When you switch to normal mode (or command mode) by typing the key sequence control+c, or by pressing the escape key, the text "-- INSERT --" disappears, indicating that you are in normal mode or command mode.

Keep in mind there's a two-division classification of vim modes, and a three-division classification.

Some people say that normal mode is part of command mode. Some people say it's a separate mode.

Normal mode is the in-between mode... it's in-between insert mode and command mode.

To get to command mode from insert mode, you first go to normal mode, and then type the key sequence shift+;

The key sequence shift+; corresponds to a colon.

You can also think of it this way...

You can say that, as soon as you type the key sequence control+c, or as soon as you type the escape key, you're in command mode.

You can save to a file by typing the command ":w myfilename.py".

You can search for a string by typing the command "/stringiwanttosearch".

I'm not sure whether I prefer the two-division or the three-division of vim modes... so I'll use both classifications in this tutorial.

I don't want to digress. Let's return to the main subject and make it more concrete.

So after we launch vim, we see a screen that says "VIM - Vi IMproved".

We type the letter "i" or the letter "a" to enter insert mode.

Now let's write a program.

    import argparse
    from addsubtract import encrypt

    def main():
        argparser = argparse.ArgumentParser(prog='asencrypt.py', description='Encrypt a message using the addsubtract algorithm')
        group = argparser.add_mutually_exclusive_group(required=True)
        group.add_argument('-m', '--message', type=str, nargs='?')
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

I wrote this code in vim using insert mode. The whole time, the text "-- INSERT --" showed in the lower left corner of my screen.

At some point, I decided to save the file.

I typed the key sequence control+c to enter command mode.

Then I typed the command ":w asencrypt.py" to save the file as "asencrypt.py".

Having saved the code to file, we can exit vim by typing the command ":q" or ":wq" in command mode.

The command ":q" quits vim. The command ":wq" first writes to file and then quits vim.

If the file has not been saved since the last change, then you either have to save the file before quitting, or type the command ":q!" to override. The command ":q!" is kind of like a force quit. Keep in mind that the quotes are not included in the commands.

I'll just say that again... when I describe vim commands, the double quotes are not meant to be included, and are only used to make it clear where the command begins and where the command ends.

So we quit vim, after saving the file. Now let's create the file asdecrypt.py.

Earlier we launched "vim" with the command "vi". Now let's launch it with the command "vi asdecrypt.py".

Now the text "asdecrypt.py [New]" should appear in the lower left corner of the screen.

Let's save the file right away. We can type the key sequence control+c and then we can type the command ":w".

The key sequence control+c means hold down the control key, press the letter c, and then release the control key.

It's kind of like how you hold down the shift key, press the letter ; (semicolon), and then release the shift key, to type a colon.

The key sequence control+c is similar to the key sequence shift+semicolon.

One gets you into command mode... the other produces a colon.

So we saved the file right away with the write command (i.e. the ":w" command).

We can even type the command ":!ls" to see a listing for our directory.

You can see that asencrypt.py and asdecrypt.py both appear in the listing.

I wanted to show you how you can open vim first without a filename argument, and then with a filename argument.

Having saved the file, we can type the key "i" or "a" to get back into insert mode.

Now that we're back in insert mode, let's write our program.

    import argparse
    from addsubtract import decrypt

    def main():
        argparser = argparse.ArgumentParser(prog='asdecrypt.py', description='Decrypt a message using the addsubtract algorithm')
        group = argparser.add_mutually_exclusive_group(required=True)
        group.add_argument('-m', '--message', type=str, nargs='?')
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

In the intervening time, we have cleverly written our decryption program.

Remember that we wrote the encryption program beforehand.

I don't know how much time I'll spend explaining the code in this tutorial...

It's more of a tutorial on vim.

But I thought it would be helpful to use this code as part of the tutorial.

I can explain the code in a future tutorial.

You can see that we use the built-in argparse library (it comes with the Python standard library) to help us parse command-line arguments.

We also import the encrypt and decrypt functions from our addsubtract library.

So the "asencrypt.py" and "asdecrypt.py" scripts are mostly concerned with command-line argument parsing.

They use the addsubtract methods to encrypt or decrypt a message.

Having written all of the code for our "asdecrypt.py" program, we can save the file with the command ":w".

Remember, we first have to type the key sequence control+c to enter command mode, and then we type the command ":w".

We can also type the command ":wq" to write to file and then quit vim, or we can type the ":w" and ":q" commands in succession.

Having written to file and quit vim, let's try running our programs.

If you type the "ls" command in Terminal, you should see the files "asencrypt.py", "asdecrypt.py", and "addsubtract.py" in the listing.

We'll test our programs by entering the message as an argument to the -m option, and the key as an argument to the -k option.

    % python asencrypt.py -m "hello world my name is andrew" -k 10e5
    87SKqPO0iqXztIqs87SKrPO0iq/ztImg87SKt/O0iq/ztIqy87SKrPO0iqTztImg87SKrfO0irnztImg87SKrvO0iqHztIqt87SKpfO0iaDztIqp87SKs/O0iaDztIqh87SKrvO0iqTztIqy87SKpfO0irc=%
    % python asdecrypt.py -m "87SKqPO0iqXztIqs87SKrPO0iq/ztImg87SKt/O0iq/ztIqy87SKrPO0iqTztImg87SKrfO0irnztImg87SKrvO0iqHztIqt87SKpfO0iaDztIqp87SKs/O0iaDztIqh87SKrvO0iqTztIqy87SKpfO0irc=" -k 10e5
    hello world my name is andrew%

You can see that our message is "hello world my name is andrew" and our key is 10e5, which is float notation for 100,000.

We encrypt this message, using the key 10e5, with the following command:

    % python asencrypt.py -m "hello world my name is andrew" -k 10e5

It produces an encrypted message that's encoded in base64.

    87SKqPO0iqXztIqs87SKrPO0iq/ztImg87SKt/O0iq/ztIqy87SKrPO0iqTztImg87SKrfO0irnztImg87SKrvO0iqHztIqt87SKpfO0iaDztIqp87SKs/O0iaDztIqh87SKrvO0iqTztIqy87SKpfO0irc=

Then we use the base64-encoded encrypted message as the input to the asdecrypt.py program. We use the same key, 10e5.

    % python asdecrypt.py -m "87SKqPO0iqXztIqs87SKrPO0iq/ztImg87SKt/O0iq/ztIqy87SKrPO0iqTztImg87SKrfO0irnztImg87SKrvO0iqHztIqt87SKpfO0iaDztIqp87SKs/O0iaDztIqh87SKrvO0iqTztIqy87SKpfO0irc=" -k 10e5

The asdecrypt.py program decrypts the encrypted message, and produces the original message.

    hello world my name is andrew

I wanted to give a play-by-play synopsis of the commands that we typed on the command-line.

We can also use the -o option to write the encrypted message to a file, and then use the -i option to read the message from file.

    % python asencrypt.py -m "hello world my name is andrew" -k 10e5 -o cipher.txt
    % python asdecrypt.py -i cipher.txt -k 10e5
    hello world my name is andrew%

I wanted to show off these options, because it explains why I included them in the first place.

The -i and -o options are useful and they can save time.

We can also fully type out the options, --message instead of -m and --key instead of -k.

    % python asencrypt.py --message "hello world my name is andrew" --key 10e5    
    87SKqPO0iqXztIqs87SKrPO0iq/ztImg87SKt/O0iq/ztIqy87SKrPO0iqTztImg87SKrfO0irnztImg87SKrvO0iqHztIqt87SKpfO0iaDztIqp87SKs/O0iaDztIqh87SKrvO0iqTztIqy87SKpfO0irc=%
    % python asdecrypt.py --message "87SKqPO0iqXztIqs87SKrPO0iq/ztImg87SKt/O0iq/ztIqy87SKrPO0iqTztImg87SKrfO0irnztImg87SKrvO0iqHztIqt87SKpfO0iaDztIqp87SKs/O0iaDztIqh87SKrvO0iqTztIqy87SKpfO0irc=" --key 10e5
    hello world my name is andrew%

Now, I wanted to show off the command-line argument parsing.

We are able to pass our message as an argument to the -m option, and our key as an argument to the -k option.

In fact, the message and key arguments are commonly called "optional arguments".

If they didn't follow an option, but instead they were parsed according to their order, they would be called "positional arguments".

You can try reversing the order of the optional arguments, and they still get parsed correctly.

But if you try reversing the order of positional arguments, they won't get parsed correctly.

I think it helps to return to the main subject of the post.

The post is entitled "vim tutorial", and the main subject of the post is how to use vim.

We were able to use vim to write our asencrypt.py and asdecrypt.py programs.

We launched vim, either using the command "vi" or "vi filename.py".

(You can replace filename with any filename.)

Then we entered insert mode by typing the letter "a" or "i". (Either key works for this purpose.)

Then we wrote our code in vim.

After writing our code (or even midway through writing our code), we saved to file using the command ":w filename.py".

(Replace filename.py with the appropriate filename, like asencrypt.py or asdecrypt.py.)

That is, for asencrypt.py we used the command ":w asencrypt.py".

For asdecrypt.py we used the command ":w asdecrypt.py".

I just wanted to be crystal clear.

After we were satisfied with the code, and after the code was written to file, we exited vim with the command ":q" or ":wq".

Then we ran the programs in Terminal, on the command-line, using the commands shown above.

Is there anything more to add to this tutorial?

Yes, I'll add one more thing.

You can actually edit the file ~/.vimrc in vim, to add line numbering, and to set the tab size in terms of spaces.

Let's do that.

I'm going to open the file ~/.vimrc using the command "vi ~/.vimrc" in Terminal.

Now type the letter "a" or "i" to enter insert mode. (Either will do.)

Now I'm going to show you the contents of my ~./vimrc file. Feel free to copy part of it or all of it.

    set tabstop=4
    set shiftwidth=4
    set expandtab
    set nu

The line "set nu" adds line numbering, which is really useful.

The rest of the lines control the size of the tab key. The tab key is set to equal four spaces.

You might ask what's the difference between shiftwidth and tabstop?

The tabstop variable controls the size of the tab key in terms of spaces (or columns).

The shiftwidth variable controls the size of an indentation (which you can achieve with >> or << in normal mode).

In fact, you can indent four lines of code by typing 4>> in normal mode. You can reverse it by typing 4<<.

Technically, the key sequence is 4+shift+.+.. But you can also write it as 4>>.

Having written this code in our ~/.vimrc file, we can save the file with the command ":wq".

Now let's open the asencrypt.py file once again.

    % ls
    __pycache__			asdecrypt.py			how_to_run_python_code.md
    addsubtract.py	    asencrypt.py			README.md
    % vim asencrypt.py

After you type the command "vim asencrypt.py" and open the asencrypt.py file, you can see that line numbering was added.

Also, the tab key should correspond to four spaces, or four visual columns, if you set tabstop to 4 and turned on the expandtab feature.

I thought it would help to talk about the ~/.vimrc file.

The ~/.vimrc file contains your personal Vim initializations.

In the simple ~/.vimrc file that we created, we turned on line numbering, we decided to replace the tab key with spaces, and we set the tab size to four spaces. So when you type the tab key, it should insert four spaces into the file at the location of the cursor.

In fact, after opening asencrypt.py in vim, we can type the command ":%!xxd" in command mode, to see a hex dump of the file.

The Unicode code point for a tab is 09 in hexadecimal. (It's equivalent to the ASCII code.)

The Unicode code point for a space is 20 in hexadecimal. (It's equivalent to the ASCII code.)

You can see, from the hex dump, that the hexadecimal characters 09 do not appear in the hex dump, outside of the line numbering.

But the hexadecimal characters 20 appear in many places. In fact, we often see the string 20202020, which corresponds to a tab.

You can see, from the hex dump, that the tab character (09) has been replaced by four spaces (20202020).

I thought it would help to show this feature in the hex dump.

That way, you don't just assume it's true... you also see it in the hexdump.

We can quit out of vim and verify this in Terminal, as well.

Let's type the key sequence control+c to enter command mode. Then, let's type the command ":q!" to quit out of vim.

After exiting vim, type the command "ls" in Terminal to verify you're in the right directory. I see this output.

    % ls
    __pycache__			asdecrypt.py			how_to_run_python_code.md
    addsubtract.py		asencrypt.py			README.md

Now type the command "hexdump -C asencrypt.py" to see a hexdump of our asencrypt.py file.

You can see that the hexadecimal characters 09 are only found in one location: in the labeling of line numbers.

The hexadecimal characters 09 are nowhere to be seen in the hexadecimal representation of the file contents.

But the hexadecimal characters 20 make an appearance in many places.

In fact, we often see the hexadecimal characters 20 appear four times in succession, which corresponds to a tab.

(Remember that we replaced tab with four spaces in our ~/.vimrc configuration file.)

I thought it would help to learn about the hexdump program, which comes pre-installed with macOS.

We can verify the tabstop feature using the ":%!xxd" command in vim, or by using the hexdump command in Terminal.

Now, I think I have written enough.

I have meandered quite a bit in this tutorial.

But I think that all of the meanderings are somehow related to the topic on hand: how to write code in vim.

We were able to compose the asencrypt.py and asdecrypt.py files in vim.

We talked at length about insert mode, normal mode, and command mode.

Some people divide vim modes into two main modes: insert mode and command mode.

Some people divide vim modes into three main modes: insert mode, normal mode, and command mode.

I wanted to use both divisions (or classifications) so that the reader can decide which division they like best.

Just remember that normal mode is the in-between mode.

You can actually use normal mode for scrolling and for editing a file.

For example, the key sequence dd in normal mode deletes a line, and the key sequence 4dd in normal mode deletes four lines.

Also, the key sequence yy in normal mode copies a line to the clipboard, and the key sequence 4yy in normal mode copies four lines to the clipboard. Then you can use the key sequence pp to paste the contents of the clipboard to the location of the cursor.

The key sequence gg in normal mode scrolls up to the top of the file and places the cursor at the top of the file.

The key sequence GG in normal mode scrolls down to the bottom of the file and places the cursor at the bottom of the file.

So you can see that insert mode is used for writing code or writing text, normal mode is used for scrolling and editing the file, and command mode is used for typing commands like write-to-file, exit-vim, search-for-a-string, search-and-replace, et cetera.

I like to say that the main modes of vim are insert mode and command mode, or insert mode, normal mode, and command mode.

Knowing the difference between insert mode and command mode goes a long way.

You need to be in insert mode to insert text into the file, and you need to be in command mode to save the file or quit vim.

Now I think it's time to wrap up this tutorial.

I uploaded the files asencrypt.py and asdecrypt.py to my Github repository.

I think that this is the longest blog post that I have written so far...

Honestly, it's not surprising.

It takes a lot of time to talk about vim.

I may have missed something important. I may have neglected to talk about something important.

But just remember, you can bring up the man pages in Terminal with the command "man vim". You can use the "vimtutor" program in Terminal with the command "vimtutor". And you can also search the internet for a tutorial on vim.

Eventually, you get the hang of it.

I have been using vim for many years and it's my favorite text editor.

Now, I think this is a good stopping point.

I hope that some of this tutorial, or all of this tutorial, is useful, helpful, and rewarding.

You can find the files, including this tutorial, in my Github repository: https://github.com/ataylor89/cryptography_tutorial/.

It's getting pretty late in the evening... I might watch a little TV and then go to sleep.

I still have some more work to do tomorrow, for my job!

Wish me luck. Thanks for reading,  
Andrew
