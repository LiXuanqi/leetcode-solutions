import os
import logging
import collections

# - config logger
loggerFormat = '%(asctime)-15s %(message)s'
logging.basicConfig(format=loggerFormat)
logger = logging.getLogger('readme-generator')
logger.setLevel(logging.DEBUG)

# - Config
choosedLanguages = ['python', 'java']
TEMPLATE_TABLE_TAG = "{{%- TABLE -%}}"
LANGUAGES = {
  'python': 'py',
  'java': 'java'
}

def formatFilename(filename, language):
  words = filename.split('-')
  index = int(words[0])
  title = ' '.join(words[1:])[:-len('.' + LANGUAGES[language])]
  url = './%s/' % (language) + filename
  logger.debug("[%d] - %s - %s" % (index, title, url))
  return index, title, url

def generateMarkdownTable(questions):
  table = """
  | ID   | Title | Java | Python |
  | :----: | :----- | :----: | :------: |
  """
  # items = []
  # for question in questions:
  #   items.append(question.toMarkdown())
  items = list(map(lambda item: item.toMarkdown(), questions.values()))
  table = table + "\n".join(items)
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
    pythonUrl = "[python](%s)" % (self.solutions['python']) if 'python' in self.solutions else ""
    markdown = "|%s|%s|%s|%s|" % (self.index, self.title, javaUrl, pythonUrl)
    return markdown


if __name__ == "__main__":
  # - get all file names
  questions = {}
  for language in choosedLanguages:
    for filename in os.listdir('./' + language):
      index, title, url = formatFilename(filename, language)
      if index not in questions:
        questions[index] = Question(index, title)
      questions[index].addSolution(language, url)
  sortedQuestions = collections.OrderedDict(sorted(questions.items()))
  
  # - Read template and generate README.md
  with open('README-template.md', 'r') as template, open('README.md', 'w') as f:
    for line in template.readlines():
      if line == TEMPLATE_TABLE_TAG: 
        table = generateMarkdownTable(sortedQuestions)
        f.write(table)
      else:
        f.write(line)
 