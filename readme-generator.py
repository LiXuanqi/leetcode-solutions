import os
import logging

# - config logger
loggerFormat = '%(asctime)-15s %(message)s'
logging.basicConfig(format=loggerFormat)
logger = logging.getLogger('readme-generator')
logger.setLevel(logging.DEBUG)

# - get all file names

for filename in os.listdir('./python'):
  words = filename.split('-')
  index = words[0]
  name = ' '.join(words[1:])
  print(filename)
  print(index)
  print(name)

