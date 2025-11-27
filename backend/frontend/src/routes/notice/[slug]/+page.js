/** @type {import('./$types').PageLoad} */
export async function load({ fetch, params }) {
	const res = await fetch(`http://3.27.115.22:8080/notice/post?postId=${params.slug}`);
    const item = await res.json();

    return { item };
}