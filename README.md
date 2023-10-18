# markdown-parser
Java program that parses markdown files to isolate the links in the file \n
run `make test`in command line to compile markdown parser and run tests \n
`MarkdownParse.getLinks(Files.readString(Paths.get("file.md")))` will get you the links in the file as an ArrayList of Strings.
