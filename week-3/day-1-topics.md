# HTML/CSS/Bootstrap Topics

Please research the below topics dealing with HTML/CSS/Bootstrap. You don't need to be a master at each point, but please be aware and familiar with the topics so that you could actually discuss them during QC/1-on-1s. As you progress along with your future projects that have frontend development as part of the requirements, you would be expected to be able to utilize HTML/CSS/Bootstrap.

Suggestions:
- Utilize https://www.w3schools.com/, which has tutorials for
    - HTML
    - CSS
    - Bootstrap
- Leverage video resources on YouTube

## HTML

- Fundamentals
  - DOCTYPE Declaration
    - `<!DOCTYPE html>`
    - Indicates HTML 5
  - `<html>`
  - `<head>`
  - `<meta charset="UTF-8">`
  - `<title>`
  - `<body>`
  - Elements
    - `<div>` - defines a "division of the page"
    - `<p>` - defines a paragraph
    - `<span>` - an inline tag for grouping text or elements
    - `<b>` - bold text
    - `<i>` - italicized text
    - `<h1>`, `<h2>`, ... `<h6>` - these are headings, h1 is largest and h6 is smallest
    - `<br>` - line break
    - `<table>` - defines a table
    - `<img src="URL">`
    - `<ol>` - an ordered list
    - `<ul>` - an unordered list
    - `<a href="">` - makes a hyperlink
  - Attributes
    - Global Attributes
      - class
      - id
      - hidden
      - lang
      - style
      - tabindex
      - title
    - Attributes for specific elements
      - src
      - alt
      - etc
  - Tables
    - `<table>`
    - `<thead>`
    - `<tbody>`
    - `<tfoot>`
    - `<th>`
    - `<tr>`
    - `<td>`
  - Lists
    - `<ol>`
    - `<ul>`
    - `<li>`
- HTML Forms
  - `<form>`
  - `<label>`
  - `<select>` & `<option>`
  - `<input>`
    - Input types
      - text
      - password
      - radio
      - checkbox
      - file
      - date
      - submit
      - reset
    - Form/Input Attributes
      - action
      - target
      - name
      - method
      - value
      - placeholder
      - required
- Semantic vs Non-Semantic Elements
  - Examples
    - Non-Semantic: `<div>` or `<span>`
    - Semantic: `<form>`, `<table>`, or `<article>`
- HTML 5 Validation
  - required
  - minlength and maxlength
  - min and max
  - type
  - pattern

## CSS
- Fundamentals
  - Selectors and Declarations
  - Example
    ```css
    h3 {
      font-family: Arial;
      font-style: italic;
      color: red
    }
    ```
- CSS Box Model
  - **Margin** - It is a space between border and margin. It is useful to separate the element from its neighbors. The dimensions are given by the margin-box width and the margin-box height
  - **Border** - It is the area between the box???s padding and margin. Its dimensions are given by the width and height of the border
  - **Padding** - It is a space around the content area and within the border-box. Its dimensions are given by the width of the padding-box and the height of the padding-box
  - **Content** - It consists of content like text, image, or other media content. It is bounded by the content edge and its dimensions are given by content-box width and height
- Ways to Include CSS
  - Inline
    - `<p style="color:#009900; font-size:50px; font-style:italic; text-align:center;">`
  - Internal
    - `<style>`
  - External
    - `<link rel="stylesheet" href="style.css"/>`
- display Property
  - inline
  - block
  - none
- position Property
  - static
  - relative
  - absolute
  - fixed
  - inherit
- text-align Property
  - left
  - right
  - center
  - justify
- Selectors
  - Element Selector
  - Id Selector
  - Class Selector
  - Universal Selector
  - Attribute selectors
  - Grouping Selector
  - Child and descendent selectors
  - General and adjacent sibling selectors
  - Pseudo-element and pseudo-class selectors
- How Specificity is used to deal with ties
- Responsive Web Design
  - The idea that websites should adapt to different displays, such as mobile vs tablet vs desktop, and even different sizes within them
  - Media Queries
  - Flex Boxes
    - Flex Container
      - **Flex direction Property** - It used to change the direction of the flex items display
        - `row` (default):  arranges the flex items from left to right (horizontally)
        - `column`: arranges the flex items from top to bottom (vertically)
        - `row-reverse`: arranges the flex items from  right to left.
        - `column-reverse`: arranges the flex items from bottom to top.
      - **Flex Wrap Property**- It is used to defines the flex items that should wrap or not
        - `nowrap` (default): makes flex items wrap on a single line.
        - `wrap`:  makes flex items wrap to multiple lines according to flex item width.
        - `wrap-reverse`:  similar to wrap property but it follows the reverse flow of the flex items.
      - **Flex-flow Property** - It is used as a shorthand property for setting both the flex-direction and flex-wrap properties
      - **justify-content Property** - It is used to align the flex items within the container
        - `flex-start` -  used to align the flex items at the beginning of the container.
        - `flex-end`  - used to align the flex items at the end of the container.
        - `center`  -  used to align the flex items at the center of the container.
        - `space-around` -  used to align the flex items in such a way each has an equal amount of space around them.
      - **align-items Property** - It is used to align the flex items vertically
        - `center` - flex items are aligned at the center  of the container.
        - `flex-start` - aligns the flex items at the top of the container.
        - `flex-end `- aligns the flex items at the bottom of the container.
        - `stretch` (default) - stretches the flex items to fill the container.
        - `baseline`-  the flex items are aligned with baseline.
    - Flex Items
      - `order`- used to define the order of the flex items
      - `flex-grow` - used to define the amount that a flex item can grow relative to the remaining items
      - `flex-shrink` - used to define the amount that a flex item can shrink relative to the remaining items
      - `flex-basis` - used to define the initial length of an item
      - `flex property` - it is a shorthand property for the flex-grow, flex-shrink, and flex-basis properties
      - `align-self`- used to define the alignment for a specific flex item which can override the default alignment
  - Importing Fonts
  - CSS Animations
  - CSS Transitions

## Bootstrap
- Bootstrap Grid System
  - Containers
    - `.container`
    - `.container-fluid`
  - Rows
    - `.row`
  - Columns
    - `.col-x` (x ranging from 1 to 12)
      - `.col-5`
      - `.col-7`
    - Column Breakpoints
      - `.col-sm` - used for small devices where the screen width is equal to or greater than 576px
      - `.col-md` - used for medium devices where the screen width equal to or greater than 768px
      - `.col-lg`- used for large devices where the screen width equal to or greater than 992px
      - `.col-xl` - used for extra-large devices where the screen width equal to or greater than 1200px
    - The above 2 can be combined
      - `.col-[breakpoint]-[size]`
- Tables
  - `.table`
  - Classes used along with `table` class
    - `.table-dark` - used to get a dark background table with the light text
    - `.table-bordered` - adds the border on all sides of the table and cells
    - `.table-striped` - used to add zebra-stripes table rows
    - `.table-hover` - applies the hover effect to the table rows and cells
    - `.thead-light`- used within `<thead>`, it makes the table header to appear light
    - `.thead-dark` - used within `<thead>`,  it makes the table header to appear dark gray
- Alerts
  - `.alert`
  - `.alert-dismissible`
- Forms
  - `.form-group`
  - `.form-label`
  - `.form-control`
- Buttons
  - `.btn`
  - `.btn-primary`
  - `btn-lg`
- Navbar
  - `.navbar-brand` - used with most elements that contain the name of the company, product, or project
  - `navbar-toggler` - used for collapse plugin and other navigation toggling behaviors (allows to change the position on mobile devices)
  - `.form-inline` - used with any form-controls and actions
  - `.navbar-text` - used to align the text vertically also makes it centered
  - `.collapse.navbar-collapse` - used for grouping and hiding navbar contents depending upon the screen resolution
- Colors
  - `.text-success`
  - `.bg-dark`