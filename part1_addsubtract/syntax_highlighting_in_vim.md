# Syntax highlighting in vim

Good afternoon, again!

For a long time I have wanted to add syntax highlighting to my vim configuration.

I put it on the back burner, and thought, "eventually I'll get around to it".

Well, today I just so happened to get around to it.

And it's a lot easier than I thought -- I don't have to download any external files. I don't have to make any major changes.

All I have to do is type the command ":syntax on" in normal mode. That turns syntax highlighting on.

If I want to turn syntax highlighting off, I type the command ":syntax off" in normal mode.

(Remember, we get to normal mode, from insert mode, by typing the escape key or typing the key sequence control+c.)

If I want syntax highlighting to be pre-enabled every time I open vim, then I add the line "syntax on" to my ~/.vimrc file.

Here are the contents of my ~/.vimrc file.

    % cat ~/.vimrc
    set tabstop=4
    set shiftwidth=4
    set expandtab
    set nu
    syntax on

I think that the line "set tabstop = 4" makes a tab count as four visual columns.

(Similarly, the line "set shiftwidth = 4" makes an indentation count as four visual columns.)

The line "set expandtab" replaces a tab (0x0a) with four spaces (0x20202020).

You can verify this by doing a hexdump of the file.

The line "set nu" adds line numbering to the screen.

The line "syntax on" adds syntax highlighting.

That's all there is to it. We can add syntax highlighting by typing the simple command ":syntax on" in normal mode, or by adding the line "syntax on" to our ~/.vimrc configuration file (which you can learn more about by typing the command ":help vimrc" in normal mode).

This is what my screen looks like without syntax highlighting: [url]https://github.com/ataylor89/screenshots/blob/main/vim_syntax_off.png[/url].

This is what my screen looks like with syntax highlighting: [url]https://github.com/ataylor89/screenshots/blob/main/vim_syntax_on.png[/url].

It's really nice that this feature is so simple to configure.

I was afraid that I would have to download some kind of "syntax highlighting configuration file", but I don't.

I can enable syntax highlighting by simply typing the command ":syntax on" in normal mode, or adding it to ~/.vimrc.

The help page for vimrc says that each line is executed as an Ex command line.

So if you have a line in your ~/.vimrc file, you can try typing it as a command in normal mode, to see what it does.

Well, I think that's all for this blog post.

I would be remiss if I wrote a three-part vim tutorial without talking at all about syntax highlighting.

Line numbering makes a big difference when you program...

It's hard for me to program without line numbering, because I like to use the command ngg, in normal mode, to skip to the nth line.

I do fine without syntax highlighting... I don't know if it's [i]as[/i] important as line numbering... but it's really nice to have the option.

We'll see, over time, whether I prefer to have syntax highlighting turned on or off.

But at the end of the day, it's important to talk about syntax highlighting, because a lot of people have a strong desire for this feature.

Maybe, months later, I'll check back in, and let you know whether I use syntax highlighting or not.

I spent a long time using vim without syntax highlighting... now we'll see what it's like with syntax highlighting turned on.

I don't want to write too much; I don't want to write too little. So I think this is a good stopping point.

It's Thursday. It's TGIF - 1. Tomorrow I'll get to say it's TGIF and then, the day after that, I'll get to sleep in. Adios, Andrew
