import requests
from bs4 import BeautifulSoup

def check_text_presence(url, target_text):
    try:
        # Make a GET request to the URL
        response = requests.get(url)
        response.raise_for_status()  # Raise an exception for bad status codes

        # Parse the HTML content of the page
        soup = BeautifulSoup(response.text, 'html.parser')

        # Check if the target text is present in the page content
        if target_text.lower() in soup.get_text().lower():
            return True
        else:
            return False

    except requests.exceptions.RequestException as e:
        print(f"Error: {e}")
        return False

# Example usage
url = 'http://18.189.30.152:8080/hello-world-maven/'
target_text = 'Avendus'

if check_text_presence(url, target_text):
    print(f"The text '{target_text}' is present on the page.")
else:
    print(f"The text '{target_text}' is not present on the page.")
