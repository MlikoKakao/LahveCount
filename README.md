# LahveCount

LahveCount is a Java console application for managing and analyzing a collection of bottles. It allows you to record information about each bottle (name, color, volume, price, and tax), view average statistics, and export or load data from files.

## 🛠️ Features

- Add, delete, and view bottles
- Calculate:
  - 📈 Average price with DPH (tax)
  - 📉 Average price without DPH
  - 🧪 Average volume (ml)
- Export to:
  - Readable `.txt` file
  - Serialized `.dat` file for programmatic use
- Load bottle data from serialized file

## 📦 Project Structure

- `Lahev.java` – Class representing a bottle with attributes (name, color, ml, price, tax)
- `LahevUtil.java` – Utility class for computing averages, saving/loading, and exporting
- `Main.java` – Main application logic with command-line interface

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/MlikoKakao/LahveCount.git
cd LahveCount
