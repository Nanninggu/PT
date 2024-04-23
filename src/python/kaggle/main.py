import os

import kaggle

# Ensure kaggle.json is in the location ~/.kaggle/kaggle.json
os.environ['KAGGLE_CONFIG_DIR'] = r"C:\Users\김승현\.kaggle\kaggle.json"

# if file exists in path, don't download it again
if not os.path.exists(r"C:\test\netflix.csv"):
    # Use the Kaggle API to download the dataset
    kaggle.api.dataset_download_files('nayanack/netflix', path=r"C:\test", unzip=True)


# Path: main.py
def print_hi(name):
    print(f'Notice: {name}')


if __name__ == '__main__':
    print_hi('Kaggle file download service is don. ' +
             'but file exist in path, so it is not downloaded again.')
