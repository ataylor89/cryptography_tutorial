#!/usr/bin/env ruby
require 'optparse'

message = nil
inputfile = nil
outputfile = nil

OptionParser.new do |opts|
    opts.banner = 'Usage: rot13.rb [-i INPUTFILE] [-o OUTPUTFILE] [message]'
    opts.on('-i', '--inputfile INPUTFILE') do |i|
        inputfile = i
    end
    opts.on('-o', '--outputfile OUTPUTFILE') do |o|
        outputfile = o
    end
end.parse!

if ARGV.size > 0
    message = ARGV[0]
end

if (message and inputfile) or (message.nil? and inputfile.nil?)
    puts 'A message or input file is required'
    exit 1
end

if inputfile
    message = File.read(inputfile)
end

message = message.tr('a-zA-Z', 'n-za-mN-ZA-M')

if outputfile
    File.write(outputfile, message)
else
    puts message
end
