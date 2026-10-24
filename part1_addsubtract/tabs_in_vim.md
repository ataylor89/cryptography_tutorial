# Tabs in vim

It's late afternoon, and I thought I would write more. I wanted to talk about creating tabs in vim.

Sometimes I like to have multiple tabs open, in vim, and switch between tabs.

Before we begin talking about tabs, I'd like to say, as a prologue, that I was a little unsure of my nomenclature (terminology) when I started writing my three-part vim tutorial, but I became a lot more sure of my terminology in part three when I discovered the help pages.

You can see in part one of my vim tutorial that I was a little unsure about terminology... what to name the different modes.

You can see in part three of my vim tutorial that I was able to reference the help pages and name the seven basic vim modes (insert, normal, command-line, visual, ex, select, terminal-job).

You can see in part one of my vim tutorial that I divided vim into two or three modes... but there are actually 7+ different modes.

You can see in part three of my vim tutorial that I was able to name the seven basic modes, by consulting the help pages.

So I became a lot more sure of my nomenclature (terminology) after I discovered the :help command and the help pages.

I think that my three-part vim tutorial clearly shows the journey I took in learning more about vim.

I started off with some knowledge, but I wanted more, and then I found what I wanted in the help pages.

That finishes my prologue... let's move on to talking about tabs in vim.

I'm going to cd into my cryptography_tutorial directory, because it contains three Python files, which we can use to create three tabs.

    % cd ~/Github/cryptography_tutorial
    % ls
    __pycache__			    how_to_run_python_code.md
    addsubtract.py	        README.md
    asdecrypt.py			test.txt
    asencrypt.py			vim_tutorial.md

You can see that the directory contains three Python files, from the directory listing.

Now I'm going to open one of those files in vim.

    % vi addsubtract.py

After typing the command "vi addsubtract.py", the vim text editor opens the addsubtract.py file, and starts out in normal mode.

Now I want to open the asencrypt.py and asdecrypt.py files as tabs, in the same vim editor.

I can achieve this by typing the command ":tabe asencrypt.py" in normal mode.

After typing this command, I see a second tab appear, with the contents of asencrypt.py in the screen.

Now I want to open a third tab, to edit the asdecrypt.py file.

I can achieve this by typing the command ":tabe asdecrypt.py" in normal mode.

I did that, and now my vim editor has three tabs.

The contents of asdecrypt.py appeared in a third tab.

Now that we have three tabs open, we need to know how to switch between tabs.

We can cycle forward through tabs (from first to last, and then wrapping around from last to first) by typing the key sequence "gt" in normal mode. That's a lowercase g and a lowercase t. Commands and key sequences are case-sensitive in vim.

Try doing that. Try cycling forward through tabs with the key sequence "gt" in normal mode (without the quotes).

Now, if you want to cycle backwards through tabs, you can do that with the key sequence "gT" (without the quotes).

In fact, you can pull up the help pages on these commands by typing ":help gt" and ":help gT" in normal mode.

It says that "gt" goes to the next tab page and wraps around from the last to the first.

It says that "gT" goes to the previous tab page and wraps around from the first to the last.

So just like "gg" and "GG" take you to the first line and the last line of the file, respectively... the key sequence "gt" takes you to the next tab and wraps around from last to first... and the key sequence "gT" takes you to the previous tab and wraps around from first to last.

Now, if you want to close a tab, you can open that tab, and type the command ":q" in normal mode.

If there are unsaved changes, then you have to save the changes, or reverse the changes, before closing the tab.

I should also mention that... if you bring up the help pages with the command ":help" or ":help <subject>", you can quit out of the help pages by typing the command ":q". This should bring you back to the file or files that you are editing.

So we can use the command ":tabe <filename>" in normal mode to open a new tab.

We can use the command ":q" in normal mode, when a tab is in focus, to close that tab.

We can use the command ":q" to exit the help pages after we use the ":help" command in normal mode.

And I think that's all there is to it. I think I said everything I wanted to say.

I want to make this post as concise as possible... so I think this is a good stopping point.

I often have multiple tabs open when I am coding a project in vim. For example, while coding the cryptography_tutorial project, I had multiple tabs open, so that I could see what the addsubtract.py file looked like while editing the asencrypt.py and asdecrypt.py files.

We are building up our knowledge of vim...

So far we have discussed the seven basic vim modes (insert, normal, command-line, visual, ex, select, terminal-job).

We have discussed many resources that we can use to learn more about vim (the man pages, the help pages, vimtutor, openvim.com, and various internet tutorials, mine included). We can also invoke vim with the -h or --help option.

    % vim -h
    % vim --help

We have discussed syntax highlighting (by means of the ":syntax on" and ":syntax off" commands which we can run in normal mode).

We have discussed tabs (by means of the ":tabe" and ":tabe <filename>" commands which we can run in normal mode).

We have already achieved a vast knowledge of vim.

But there's more to learn... like select mode and terminal-job mode and other ways that we can apply visual mode.

So, by way of an epilogue, I would like to say, we have learned a lot about vim.

It's my favorite text editor. I love using the command-line and I love using Terminal.

    % cd ~/Github/cryptography_tutorial
    % ls -1
    __pycache__
    addsubtract.py
    asdecrypt.py
    asencrypt.py
    how_to_run_python_code.md
    README.md
    vim_tutorial.md
    % vi addsubtract.py
    :tabe asencrypt.py
    :tabe asdecrypt.py
    :syntax off
    :syntax on

I hope this post clearly explains the tab feature in vim.

Remember you can type ":help tabe", in normal mode, to bring up the help page for the tabe command.

Now I have to get back to work. I have some work due tomorrow.

I really enjoyed writing this blog post as a break.

I wish everyone a nice weekend. TGIF - 1. TGIF to infinity.

Thanks for reading,  
Andrew
