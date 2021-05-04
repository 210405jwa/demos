module.exports = {
    module: {
        rules: [
            {
                test: /\.js$/,
                exclude: /node_modules/,
                use: {
                    // Babel is a common tool used in JavaScript development that can translate newer versions of ECMAScript
                    // to older versions, such that we can reach a wider audience who might be running older browser versions
                    // that don't understand newer versions of ES
                    // Babel is also used to "transpile" TypeScript into plain JS
                    loader: 'babel-loader'
                }
            }
        ]
    }
}