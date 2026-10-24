#!/usr/bin/env perl
# Use Perl 5.34 or higher (needed for try/catch)
use v5.34; 
use strict;
use warnings;
# We want to use the try/catch feature introduced in Perl 5.34
use feature 'try';
# This is needed for Perl 5.34-5.38, but not in Perl 5.40 or higher
no warnings 'experimental::try';
# This module helps us parse command-line arguments
use Getopt::Long;
# This module helps us slurp a file and spew to a file
use Path::Tiny;

my $message = "";
my $input_file = "";
my $output_file = "";

try {
    # Parse keyword arguments
    GetOptions(
        "inputfile|i=s" => \$input_file,
        "outputfile|o=s" => \$output_file
    );

    # Parse positional argument
    $message = shift @ARGV;

    # Basic validation
    if (($message && $input_file) || (!$message && !$input_file)) {
        print "A message or an input file is required.\n";
        exit 1;
    }

    # If there's an input file, read the message from the input file
    if ($input_file) {
        $message = path($input_file)->slurp_utf8;
    }    

    # Use Perl's built-in translate operator
    $message =~ tr/a-zA-Z/n-za-mN-ZA-M/;

    # If there's an output file, spew message to the output file
    if ($output_file) {
        path($output_file)->spew_utf8($message);
    }

    # Else print the message to stdout
    else {
        print $message;
    }
}
catch ($e) {
    print "$e";
    exit 1;
};
