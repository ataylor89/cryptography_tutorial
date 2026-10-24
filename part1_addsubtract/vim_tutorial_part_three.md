# vim tutorial (part three)

Good afternoon! I like to say, on Thursdays, that it is TGIF-1.

TGIF is an acronym that means "thank God it's Friday".

It's not Friday yet... but we can say, it's TGIF-1.

Thursday is really as exciting as Friday. Because I can look forward to sleeping in on Saturday morning.

Anyway, let's return to our vim tutorial.

In part two, I mentioned three sources that are really helpful.

1. https://vim.rtorr.com/
2. openvim.com
3. https://web.stanford.edu/class/cs107/resources/vim

I'd like to add a fourth source that is really helpful.

4. The :help command in normal mode

Let's start by opening Terminal. If Terminal is not already pinned to your dock, you can find it by opening Finder, navigating to Applications, navigating to the subfolder Utilities, and then double-clicking on the Terminal icon.

After you open Terminal, it should appear in your Dock. You can right-click the Terminal icon and select "Options->Keep in Dock" to save Terminal to your Dock, so that you can easily open it later just by clicking on the icon in your Dock.

Okay, great. Let's assume that you have opened Terminal and you see it on your screen.

Now type the command "vi" in Terminal (without the quotes). This should open the vim text editor.

When you open vim, it should start out in normal mode.

To use the help command, type :help in normal mode.

(If you happen to be in insert mode, which is indicated by the label -- INSERT -- in the lower left corner, press the escape key or type the key sequence control+c to enter normal mode from insert mode. You can type the "i" key or the "a" key to enter insert mode from normal mode. The :help command is a normal mode command, so be sure that you're in normal mode before we proceed.)

The :help command brings up a document entitled "VIM - main help file".

We can use the :help command without an argument to bring up the main help file.

We can also use the :help command with an argument to search a specific subject.

Assuming you're in normal mode, type the command ":help vim-modes", without the quotes.

The help page for this subject (vim-modes) says that vim has seven basic modes.

The seven basic modes are:

1. Insert mode
2. Normal mode
3. Command-line mode
4. Visual mode
5. Ex mode
6. Select mode
7. Terminal-Job mode

I wanted to share this because... it's actually a great way to classify the basic vim modes.

Earlier I was a bit unsure of my terminology. Now I am more sure-footed. I have the :help pages to guide me.

When we open vim, it starts out in normal mode.

We can type the "i" or "a" keys to enter insert mode.

We can type the escape key or the key sequence control+c to get back into normal mode.

When we're in normal mode, we can type the : key (shift+semicolon) to enter command-line mode.

When we're in normal mode, we can type the "v" key to enter visual mode.

Visual mode allows us to easily highlight text and copy/paste.

Let's show this with a demo.

I'm going to enter the following text into my file, while using vim in insert mode.

    hello world
    i am writing this tutorial for aops
    my name is andrew
    today is thursday july 30 2026

Now I'm going to enter normal mode by typing the escape key.

Now I'm going to move my cursor to the top left of the file, so that it highlights the "h" in "hello world".

Now I'm going to enter visual mode by typing the "v" key.

After entering visual mode, I can use the down arrow, and the right arrow, to highlight all of my text, starting from the top left.

I can use the "y" key to copy my text.

Now I can place my cursor at the bottom of the file, on line six, and type the "p" key to paste the contents of my clipboard.

After doing so, my file looks like this:

    hello world
    i am writing this tutorial for aops
    my name is andrew
    today is thursday july 30 2026

    hello world
    i am writing this tutorial for aops
    my name is andrew
    today is thursday july 30 2026

So you can see that I used visual mode, specifically the highlight feature, to copy/paste a block of text.

I wanted to give a quick demo of visual mode, because I didn't mention it in part one or part two.

But let's return to the :help page for vim-modes.

The :help page for vim-modes (which you can bring up with the command ":help vim-modes") names seven basic modes.

1. Insert mode
2. Normal mode
3. Command-line mode
4. Visual mode
5. Ex mode
6. Select mode
7. Terminal-Job mode

If we're in normal mode, we can type the command ":w /path/to/file" to save the file.

(For example, the command ":w /tmp/test.txt" saves the file to my /tmp directory under the filename test.txt.)

I just saved the file to the path /tmp/test.txt.

We actually accomplished this from command-line mode, which we enter after we type the : key (shift+semicolon) in normal mode.

After typing the command ":w /tmp/test.txt", we are back in normal mode.

We can type the key sequence GG to go to the last line in the file.

We can type the key sequence gg to go to the first line in the file.

We can type the key sequence 6gg to go to the sixth line in the file.

We can use normal mode for scrolling and editing.

After typing the key sequence 6gg, which brings us to the sixth line in the file, we can type the key sequence 4dd, which deletes four lines of text, starting at the position of the cursor. Now we can type the "u" key to undo it.

We accomplished all of this from normal mode.

You can see that insert mode is for writing, normal mode is for scrolling and editing, and command-line mode is for commands.

We can use visual mode to highlight text and copy/paste text (this is one application of visual mode).

We can use Ex mode to type a series of commands, without having to type the : key.

We can enter Ex mode by typing the "Q" key (without the quotes) in normal mode. (That is, shift+q or Q.)

We can return to normal mode, from Ex mode, by typing the command "vi" or "visual" in Ex mode.

If you bring up the :help page for vim-modes once again, by typing the command ":help vim-modes" in normal mode, you'll see that each mode has a hyphenated string associated with it. You can bring up the help page for this mode by passing this hyphenated string as an argument to the :help command.

For example, the command ":help normal-mode" brings up the help page for normal mode.

The command ":help insert-mode" brings up the help page for insert mode.

The command ":help cmdline-mode" brings up the help page for command-line mode.

The commands ":help visual-mode" and ":help ex-mode" bring up the help pages for visual mode and ex mode, respectively.

I wanted to end this tutorial by talking about the :help command and the help pages.

We can learn vim terminology by consulting the help pages, using the :help command in vim.

I struggled to classify the vim modes, earlier, because I did not feel sure of my nomenclature.

But the help pages give me a very clear terminology for naming the basic vim modes.

The seven basic vim modes, according to the help pages, are the following:

1. Insert mode
2. Normal mode
3. Command-line mode
4. Visual mode
5. Ex mode
6. Select mode
7. Terminal-Job mode

I have discussed five of the seven modes in this blog post.

Maybe some other time we can talk about select mode and terminal-job mode.

But I think my work is finished for now. I wanted to describe the help pages in depth, and I did.

We can bring up the help pages by typing the :help command, in vim, from normal mode, with or without an argument.

For example, the ":help" command brings up the main help file, and the ":help vim-modes" command brings up the vim modes intro.

One of my goals in writing these tutorials was to classify the different vim modes.

We were able to name the seven basic vim modes, and talk about five of them in depth.

I'm satisfied with the result... and I'm excited for the next blog post.

I'm planning to write a blog post on sorting a list, using the quicksort algorithm, sometime soon :)

In my post "The sum of the first n squares", I said that some math problems have a key.

What is the key to remembering the quicksort algorithm?

Well, I think the key is to remember several important ideas.

Sometimes, we only have to remember one trick or idea, to remember the solution to a problem.

Sometimes, we have to remember many tricks or many ideas, to remember a solution or implementation.

To remember the implementation of the quicksort algorithm, you have to remember many important ideas, like, "the recursion condition for the quicksort method is if low < high and the first statement in the partition method is to initialize i to low - 1".

I'm excited for my next blog post, and I wanted to give a preview.

I think that wraps up this blog post. We were able to name the seven basic vim modes (insert mode, normal mode, command-line mode, visual mode, ex mode, select mode, and terminal-job mode) and talk about five of the seven modes in detail.
