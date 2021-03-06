#!/usr/bin/python
import os
import logging
import collections
import json
# - config logger
loggerFormat = '%(asctime)-15s %(message)s'
logging.basicConfig(format=loggerFormat)
logger = logging.getLogger('readme-generator')
logger.setLevel(logging.INFO)

# - Config
choosedLanguages = ['python3', 'java']
TEMPLATE_TABLE_TAG = "{%-- TABLE --%}"
LANGUAGES = {
  'python3': 'py',
  'java': 'java'
}

def formatFilename(filename, language):
  words = filename.split('.')
  index = int(words[0])
  title = ' '.join(words[1:])[:-len('.' + LANGUAGES[language])]
  url = './%s/' % (language) + filename
  logger.debug("[%d] - %s - %s" % (index, title, url))
  return index, title, url

def generateMarkdownTable(questions):
  logger.info('Starting generate markdown table.')
  table = """
  | ID   | Title | Java | Python |
  | :----: | :----- | :----: | :------: |
  """
  items = list(map(lambda item: item.toMarkdown(), questions.values()))
  table = table + "\n".join(items)
  logger.info('Finish generate markdown table.')
  return table

class Question:
  def __init__(self, index, title):
    self.index = index
    self.title = title
    self.solutions = {}

  def addSolution(self, language, url):
    self.solutions[language] = url

  def toMarkdown(self):
    javaUrl = "[java](%s)" % (self.solutions['java']) if 'java' in self.solutions else ""
    pythonUrl = "[python3](%s)" % (self.solutions['python3']) if 'python3' in self.solutions else ""
    markdown = "|%s|%s|%s|%s|" % (self.index, self.title, javaUrl, pythonUrl)
    return markdown


if __name__ == "__main__":
  logger.info('Starting read local solutions and generate question list')
  # - get all file names
  questions = {}
  for language in choosedLanguages:
    folderName = "%s/%s" % (os.path.abspath(os.path.dirname(__file__)), language)
    for filename in os.listdir(folderName):
      index, title, url = formatFilename(filename, language)
      if index not in questions:
        questions[index] = Question(index, title)
      questions[index].addSolution(language, url)
  sortedQuestions = collections.OrderedDict(sorted(questions.items()))
  logger.info('Finish generate question list, there are %d questions' % (len(sortedQuestions)))  
  # - Read template and generate README.md
  templatePath = "%s/%s" % (os.path.abspath(os.path.dirname(__file__)), 'README-template.md')
  readmePath = "%s/%s" % (os.path.abspath(os.path.dirname(__file__)), 'README.md')
  with open('README-template.md', 'r') as template, open('README.md', 'w') as f:
    logger.info('Starting write file')
    for line in template.readlines():
      print(line)
      if TEMPLATE_TABLE_TAG in line: 
        print('match')
        table = generateMarkdownTable(sortedQuestions)
        f.write(table)
      else:
        f.write(line)
    logger.info('Finished!')
    
 
