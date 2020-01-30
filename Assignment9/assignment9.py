#                  Lambert Longnang
#                  Assignment9
#                  December, 01 2019

import sys
import operator


args = sys.argv

if len(args) != 3:
   exit("Not enough arguments please pass 2 arguments")

storyFileName = args[1]
skipWordsFileName = args[2]


with open(storyFileName, 'r') as storyFile:
   storyString = storyFile.read()
   print('Story filename: ' + storyFileName)

with open(skipWordsFileName, 'r') as skipWordsFile:
   skipWordsString = skipWordsFile.read()
   skiplist = skipWordsString.split(',')
   print('Skip word file name: ' + skipWordsFileName)
   print('Skip words: ' + str(skiplist))
 


erasures = ['\n','\t','.','?','!',',',';',':','\'','\"']
for character in erasures:
   storyString = storyString.replace(character, ' ')

skipWordsList = skipWordsString.split(',')

storyString = storyString.lower()
storySplitList = storyString.split()
storySplitList = [word for word in storySplitList if word not in skipWordsList]
storyString = ' '.join(storySplitList)

storyList = storyString.split(' ')
storyList = list(filter(lambda x: x != '', storyList))

PairCount = {}
for i in range(len(storyList) - 1):
   if (storyList[i] + ' ' + storyList[i+1]) in PairCount:
       PairCount[storyList[i] + ' ' + storyList[i + 1]] += 1
   else:
       PairCount[storyList[i] + ' ' + storyList[i + 1]] = 1


dctionaryCount = sorted(PairCount.items(), key=operator.itemgetter(1))


print("The five most frequently occurring word pairs are:")

for i in range(1, 6):
    print(dctionaryCount[-i])


