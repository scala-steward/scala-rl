# Contributing to ScalaRL

This page lists recommendations and requirements for how to best contribute to ScalaRL. We strive to obey these as best as possible. As always, thanks for contributing - we hope these guidelines make it easier and shed some light on our approach and processes.

## Key branches

- `master` is the latest, deployed version.
- `develop` is where development happens and all pull requests should be submitted.

## Pull requests

Submit pull requests against the `develop` branch. Try not to pollute your pull request with unintended changes. Keep it simple and small.

## Contributing Tests

We don't have strong conventions around our tests, but here are a few guidelines that might help.

### Scalacheck Properties

If you're adding [scalacheck](https://scalacheck.org/) properties... hold tight, more coming soon. Here's an example of an example:

```scala
package com.scalarl

import org.scalacheck.Prop

class ExampleLaws extends ??? {
  // Fill in!
}
```

### Scalatest

We use [scalatest](http://www.scalatest.org/) for all of our other tests.

## Contributing Documentation

The documentation for ScalaRL's website is stored in the `docs/src/main/tut` directory of the [docs subproject](https://github.com/sritchie/scala-rl/tree/develop/docs).

ScalaRL's documentation is powered by [sbt-microsites](https://47deg.github.io/sbt-microsites/) and [tut](https://github.com/tpolecat/tut). `tut` compiles any code that appears in the documentation, ensuring that snippets and examples won't go out of date.

We would love your help making our documentation better. If you see a page that's empty or needs work, please send us a pull request making it better. If you contribute a new data structure to ScalaRL, please add a corresponding documentation page. To do this, you'll need to:

- Add a new Markdown file to `docs/src/main/tut/datatypes` with the following format:

```markdown
---
layout: docs
title:  "<Your Page Title>"
section: "data"
source: "scala-rl-core/src/main/scala/io/samritchie/rl/<YourDataType>.scala"
scaladoc: "#scalarl.<YourDataType>"
---

# Your Data Type

.....
```

- Make sure to add some code examples! Any code block of this form will get compiled using `tut`:


    ```toot:book
    <your code>
    ```

(Please replace `toot` with `tut`!) `tut` will evaluate your code as if you'd pasted it into a REPL and insert each line's results in the output. State persists across `tut` code blocks, so feel free to alternate code blocks with text discussion. See the [tut README](https://github.com/tpolecat/tut) for more information on the various options you can use to customize your code blocks.
- Add your page to the appropriate section in [the menu](https://github.com/sritchie/scala-rl/tree/develop/docs/src/main/resources/microsite/data/menu.yml)

### Generating the Site

run `sbt docs/makeMicrosite` to generate a local copy of the microsite.

### Previewing the site

1. Install jekyll locally, depending on your platform, you might do this with any of the following commands:

```
yum install jekyll
apt-get install jekyll
gem install jekyll
```

2. In a shell, navigate to the generated site directory in `docs/target/site`
3. Start jekyll with `jekyll serve --incremental`
4. Navigate to http://127.0.0.1:4000/scala-rl/ in your browser
5. Make changes to your site, and run `sbt docs/makeMicrosite` to regenerate the site. The changes should be reflected as soon as `sbt docs/makeMicrosite` completes.

## Post-release

After the release occurs, you will need to update the documentation. Here is a list of the places that will definitely need to be updated:

 * `README.md`: update version numbers
 * `CHANGES.md`: summarize changes since last release

(Other changes may be necessary, especially for large releases.)

You can get a list of changes between release tags `v0.1.2` and `v0.2.0` via `git log v0.1.2..v0.2.0`. Scanning this list of commit messages is a good way to get a summary of what happened, although it does not account for conversations that occurred on Github. (You can see the same view on the Github UI by navigating to <https://github.com/sritchie/scala-rl/compare/v0.1.2...v0.2.0>.)

Once the relevant documentation changes have been committed, new [release notes](https://github.com/sritchie/scala-rl/releases) should be added. You can add a release by clicking the "Draft a new release" button on that page, or if the relevant release already exists, you can click "Edit release".

The website should then be updated via `sbt docs/publishMicrosite`.

## License

By contributing your code, you agree to license your contribution under the terms of the [APLv2](LICENSE).
