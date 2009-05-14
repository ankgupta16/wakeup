import os

JAVA_GPL = """/*
Copyright (C) 2009 Gopalkrishna Sharma.
Email: gopalkri@umich.edu / gopalkrishnaps@gmail.com

This file is part of WakeUp!.

Wake Up! is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

Wake Up! is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Wake Up!.  If not, see <http://www.gnu.org/licenses/>.
*/

"""

XML_GPL = """<!--
Copyright (C) 2009 Gopalkrishna Sharma.
Email: gopalkri@umich.edu / gopalkrishnaps@gmail.com

This file is part of WakeUp!.

Wake Up! is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

Wake Up! is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Wake Up!.  If not, see <http://www.gnu.org/licenses/>.
-->
"""

SRC_FILE_EXTNS = ['.java', '.xml']

def removeGPLFromFile(srcfile):
    fin = open(srcfile, 'r')
    content = fin.read()
    fin.close()
    if srcfile.endswith('.xml'):
        print 'POS: ', content.find(XML_GPL)
        content = content.replace(XML_GPL, '')
        print "Removing GPL statement from file:", srcfile
    elif srcfile.endswith('.java'):
        print 'POS: ', content.find(JAVA_GPL)
        content = content.replace(JAVA_GPL, '')
        print "Removing GPL statement from file:", srcfile
    fout = open(srcfile, 'w')
    fout.write(content)
    print content
    fout.close()

def isSrcFile(filename):
    for extn in SRC_FILE_EXTNS:
        if filename.endswith(extn):
            return True
    return False

def getAllSrcFiles(rootdir):
    files = []
    entries = os.listdir(rootdir)
    for entry in entries:
        entry = os.path.join(rootdir, entry)
        if os.path.isdir(entry):
            for f in getAllSrcFiles(entry):
                files.append(f)
        if os.path.isfile(entry) and isSrcFile(entry):
            files.append(entry)
    return files

def main():
    for srcfile in getAllSrcFiles('.'):
        removeGPLFromFile(srcfile)

if __name__ == '__main__':
    main()

