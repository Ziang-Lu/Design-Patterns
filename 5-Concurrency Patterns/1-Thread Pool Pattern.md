# Thread Pool Pattern (线程池模式)

## Definition & Explanation

This pattern is an application of <a href="https://github.com/Ziang-Lu/Design-Patterns/blob/master/2-Creational%20Patterns/5-Object%20Pool%20Pattern/Object%20Pool%20Pattern.md">Object Pool Pattern</a>.



<br>

## Code Example

```python
import concurrent.futures as cf

import requests

sites = [
    'http://europe.wsj.com/',
    'http://some-made-up-domain.com/',
    'http://www.bbc.co.uk/',
    'http://www.cnn.com/',
    'http://www.foxnews.com/',
]


def site_size(url: str) -> int:
    """
    Returns the page size in bytes of the given URL.
    :param url: str
    :return: str
    """
    response = requests.get(url)
    return len(response.content)


# Create a thread pool with 10 threads
with cf.ThreadPoolExecutor(max_workers=10) as pool:
    # Prepare Future objects to be executed
    future_to_url = {pool.submit(site_size, url): url for url in sites}
    # Execute each Future object and get the result
    for future in cf.as_completed(future_to_url.keys()):
        url = future_to_url[future]
        try:
            page_size = future.result()
        except Exception as e:
            print(f'{url} generated an exception: {e}')
        else:
            print(f'{url} page is {page_size} bytes.')

# Output:
# http://some-made-up-domain.com/ page is 301 bytes.
# http://www.foxnews.com/ page is 216594 bytes.
# http://www.cnn.com/ page is 1725827 bytes.
# http://europe.wsj.com/ page is 979035 bytes.
# http://www.bbc.co.uk/ page is 289252 bytes.
```

